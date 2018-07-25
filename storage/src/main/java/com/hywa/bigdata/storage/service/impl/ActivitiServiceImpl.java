package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.common.activiti.ActivitiUtils;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.exception.GlobalException;
import com.hywa.bigdata.storage.mapper.BaseProcessInfoMapper;
import com.hywa.bigdata.storage.mapper.OrderdetailMapper;
import com.hywa.bigdata.storage.service.ActivitiService;
import com.hywa.bigdata.storage.service.RuTaskNodeInfoService;
import com.hywa.bigdata.storage.service.SysUserService;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

//activiti在5.12版本后推出了动态bpmn模型部署
@Service
public class ActivitiServiceImpl implements ActivitiService {

	@Autowired
	RepositoryService repositoryService;

	@Autowired
	TaskService taskService;

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	HistoryService historyService;

	@Autowired
	ManagementService managementService;

	@Autowired
	SysUserService sysUserService;

	@Autowired
	BaseProcessInfoMapper baseProcessInfoMapper;

	@Autowired
	OrderdetailMapper orderdetailMapper;

	@Autowired
	RuTaskNodeInfoService ruTaskNodeInfoService;

	// 构建动态模型
	@Override
	@Transactional
	public Deployment deploy(BaseProcessInfo baseProcessInfo, List<TaskNodeInfo> taskNodeInfos) throws IOException {
		// 创建bpmn模型,通过process来添加具体信息
		BpmnModel model = new BpmnModel();
		Process process = new Process();
		// 流程名称
		String processId = "process" + baseProcessInfo.getId();
		process.setId(processId);
		model.addProcess(process);
		// 创建bpmn元素
		// 对flowWorkInfo中的元素按sort顺序取出
		Collections.sort(taskNodeInfos, new Comparator<TaskNodeInfo>() {
			@Override
			public int compare(TaskNodeInfo fi1, TaskNodeInfo fi2) {
				return fi1.getSort() - fi2.getSort();
			}
		});
		// 去除首尾
		taskNodeInfos.remove(taskNodeInfos.get(0));
		taskNodeInfos.remove(taskNodeInfos.get(taskNodeInfos.size() - 1));
		buildingTask(taskNodeInfos, process, processId);
		// 3. 部署这个BPMN模型,部署名统一为流程名字
		Deployment deployment = repositoryService.createDeployment().addBpmnModel(processId + ".bpmn", model)
				.name(processId).deploy();
		// 4. 保存为bpmn.xml的xml类型文件
		InputStream processBpmn = repositoryService.getResourceAsStream(deployment.getId(), processId + ".bpmn");
		// 部署到指定的processes文件夹下
		new File("src\\main\\resources\\processes\\" + processId + ".xml").delete();
		FileUtils.copyInputStreamToFile(processBpmn,
				new File("src\\main\\resources\\processes\\" + processId + ".xml"));
		// 发布成功,修改为启动状态
		if (null != deployment) {
			baseProcessInfo.setIsStartUsing(1);
			baseProcessInfoMapper.updateByPrimaryKeySelective(baseProcessInfo);
			Boolean aBoolean = ruTaskNodeInfoService.updateRuTaskInfo(baseProcessInfo.getId());
			if (!aBoolean) {
				throw new GlobalException(1, "节点信息更新失败");
			}
		}
		return deployment;
	}

	// 删除流程
	@Override
	@Transactional
	public AjaxJson delDeploy(String processId, Boolean b) {
		BaseProcessInfo baseProcessInfo = baseProcessInfoMapper.selectByPrimaryKey(processId);
		repositoryService.deleteDeployment(processId, b);
		return new AjaxJson(0, AjaxJson.MSGSUCCESS);
	}

	// 回退至上一步
	@Override
	public AjaxJson taskRollBack(String taskId, String opinion) {
		try {
			Map<String, Object> variables;
			// 取得当前任务
			HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(taskId)
					.singleResult();
			// 取得流程实例
			ProcessInstance instance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(currTask.getProcessInstanceId()).singleResult();
			if (instance == null) {

				// 流程结束
			}
			variables = instance.getProcessVariables();
			// 取得流程定义
			ProcessDefinitionEntity definition = (ProcessDefinitionEntity) (repositoryService
					.getProcessDefinition(currTask.getProcessDefinitionId()));

			if (definition == null) {
				return new AjaxJson(1, "流程定义未找到");
			}
			// 取得上一步活动
			ActivityImpl currActivity = ((ProcessDefinitionImpl) definition)
					.findActivity(currTask.getTaskDefinitionKey());
			List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();
			// 清除当前活动的出口
			List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
			List<PvmTransition> pvmTransitionList = currActivity.getOutgoingTransitions();
			for (PvmTransition pvmTransition : pvmTransitionList) {
				oriPvmTransitionList.add(pvmTransition);
			}
			pvmTransitionList.clear();

			// 建立新出口
			List<TransitionImpl> newTransitions = new ArrayList<TransitionImpl>();
			for (PvmTransition nextTransition : nextTransitionList) {
				PvmActivity nextActivity = nextTransition.getSource();
				ActivityImpl nextActivityImpl = ((ProcessDefinitionImpl) definition).findActivity(nextActivity.getId());
				TransitionImpl newTransition = currActivity.createOutgoingTransition();
				newTransition.setDestination(nextActivityImpl);
				newTransitions.add(newTransition);
			}
			// 完成任务
			List<org.activiti.engine.task.Task> tasks = taskService.createTaskQuery()
					.processInstanceId(instance.getId()).taskDefinitionKey(currTask.getTaskDefinitionKey()).list();
			for (org.activiti.engine.task.Task task : tasks) {
				String procInstanceId = taskService.createTaskQuery().taskId(task.getId()).singleResult()
						.getProcessInstanceId();
				// 添加审核意见
				taskService.addComment(task.getId(), procInstanceId, opinion);
				taskService.complete(task.getId(), variables);
				historyService.deleteHistoricTaskInstance(task.getId());
			}
			// 恢复方向
			for (TransitionImpl transitionImpl : newTransitions) {
				currActivity.getOutgoingTransitions().remove(transitionImpl);
			}
			for (PvmTransition pvmTransition : oriPvmTransitionList) {
				pvmTransitionList.add(pvmTransition);
			}
			return new AjaxJson(0, "审核回退成功");
		} catch (Exception e) {
			return new AjaxJson(1, "审核回退失败");
		}
	}

	// 根据当前任务获取下个任务信息
	@Override
	public PvmActivity getNextNode(String taskId) {
		// 1、首先是根据流程ID获取当前任务：
		Task taskQuery = taskService.createTaskQuery().taskId(taskId).singleResult();
		if (null == taskQuery)
			return null;
		String procInstanceId = taskQuery.getProcessInstanceId();
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(procInstanceId).list();
		PvmActivity ac = null;
		String taskType = "";
		for (Task task : tasks) {
			// 2、然后根据当前任务获取当前流程的流程定义，然后根据流程定义获得所有的节点：
			ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
					.getDeployedProcessDefinition(task.getProcessDefinitionId());
			List<ActivityImpl> activitiList = def.getActivities(); // rs是指RepositoryService的实例
			// 3、根据任务获取当前流程执行ID，执行实例以及当前流程节点的ID：
			String excId = task.getExecutionId();
			ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(excId)
					.singleResult();
			String activitiId = execution.getActivityId();
			// 4、然后循环activitiList
			// 并判断出当前流程所处节点，然后得到当前节点实例，根据节点实例获取所有从当前节点出发的路径，然后根据路径获得下一个节点实例：
			for (ActivityImpl activityImpl : activitiList) {
				String id = activityImpl.getId();
				if (activitiId.equals(id)) {
					List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();// 获取从某个节点出来的所有线路
					for (PvmTransition tr : outTransitions) {
						ac = tr.getDestination(); // 获取线路的终点节点
					}
					break;
				}
			}
		}
		return ac;
	}

	private Process buildingTask(List<TaskNodeInfo> taskNodeInfos, Process process, String processId) {
		// 开始节点
		process.addFlowElement(ActivitiUtils.createStartEvent());
		// 此处就以排序后的任务进行部署
		List<String> taskIds = new ArrayList<>();
		taskNodeInfos.forEach(task -> {
			// id名开头不能是数字
			String taskId = processId + IDUtils.genId();
			List<String> taskUsers = new ArrayList<>();
			if (!StringUtils.isEmpty(task.getDepartment())) {
				List<String> byDepartments = Arrays.asList(task.getDepartment().split(","));
				taskUsers.addAll(byDepartments);
			}
			if (!StringUtils.isEmpty(task.getAssignee())) {
				List<String> assignee = Arrays.asList(task.getAssignee().split(","));
				taskUsers.addAll(assignee);
			}
			process.addFlowElement(ActivitiUtils.createGroupTask(taskId, task.getName(), taskUsers));
			taskIds.add(taskId);
		});
		process.addFlowElement(ActivitiUtils.createEndEvent());
		// 创建序列流(流程中的顺序)
		process.addFlowElement(ActivitiUtils.createSequenceFlow("start", taskIds.get(0)));
		for (int i = 1; i < taskNodeInfos.size(); i++) {
			process.addFlowElement(ActivitiUtils.createSequenceFlow(taskIds.get(i - 1), taskIds.get(i)));
		}
		process.addFlowElement(ActivitiUtils.createSequenceFlow(taskIds.get(taskNodeInfos.size() - 1), "end"));
		return process;
	}
}
