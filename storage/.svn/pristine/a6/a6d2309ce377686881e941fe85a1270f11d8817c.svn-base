package com.hywa.bigdata.storage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.ContextHolderUtils;
import com.hywa.bigdata.storage.common.HttpClientUtil;
import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.common.JsonUtils;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.HiCompleteTask;
import com.hywa.bigdata.storage.entity.HiHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HiOrderdetail;
import com.hywa.bigdata.storage.entity.HiTaskNodeInfo;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HouseBigEntrepotEntity;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.RollBackOrderInfo;
import com.hywa.bigdata.storage.entity.RuHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.RuTaskNodeInfo;
import com.hywa.bigdata.storage.entity.User;
import com.hywa.bigdata.storage.entity.constant.ConstantMap;
import com.hywa.bigdata.storage.exception.GlobalException;
import com.hywa.bigdata.storage.mapper.OrderdetailMapper;
import com.hywa.bigdata.storage.mapper.RollBackOrderInfoMapper;
import com.hywa.bigdata.storage.mapper.RuTaskNodeInfoMapper;
import com.hywa.bigdata.storage.service.ActivitiService;
import com.hywa.bigdata.storage.service.BaseProcessInfoService;
import com.hywa.bigdata.storage.service.HiCompleteTaskService;
import com.hywa.bigdata.storage.service.HiHomepageHandleDesigningService;
import com.hywa.bigdata.storage.service.HiNodeInfoService;
import com.hywa.bigdata.storage.service.HiOrderdetailService;
import com.hywa.bigdata.storage.service.HiTaskNodeInfoService;
import com.hywa.bigdata.storage.service.OrderdetailService;
import com.hywa.bigdata.storage.service.RuHomepageHandleDesigningService;
import com.hywa.bigdata.storage.service.RuTaskNodeInfoService;
import com.hywa.bigdata.storage.service.SysUserService;
import com.hywa.bigdata.storage.service.WorkFlowService;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {

	@Value("${business_url}")
	private String business_url;

	@Value("${base_url}")
	private String base_url;

	@Autowired
	OrderdetailMapper orderdetailMapper;

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	RuTaskNodeInfoMapper ruTaskNodeInfoMapper;

	@Autowired
	OrderdetailService orderdetailService;

	@Autowired
	RuTaskNodeInfoService ruTaskNodeInfoService;

	@Autowired
	RuHomepageHandleDesigningService ruHomepageHandleDeigningService;

	@Autowired
	ActivitiService activitiService;

	@Autowired
	TaskService taskService;

	@Autowired
	BaseProcessInfoService baseProcessInfoService;

	@Autowired
	SysUserService sysUserService;

	@Autowired
	HiNodeInfoService hiNodeInfoService;

	@Autowired
	HiCompleteTaskService hiCompleteTaskService;

	@Autowired
	HiOrderdetailService hiOrderdetailService;

	@Autowired
	HiTaskNodeInfoService hiTaskNodeInfoService;

	@Autowired
	HiHomepageHandleDesigningService hiHomepageHandleDesigningService;

	@Autowired
	RollBackOrderInfoMapper rollBackOrderInfoMapper;

	// 第一次保存,就存入历史表,但不涉及查历史表
	@Override
	@Transactional
	public AjaxJson saveOrderdetail(Orderdetail orderdetail, User user) throws ParseException {
		// 基础数据保存
		orderdetail.setBaseInfo(user,
				orderdetailService.isEmpty() ? IDUtils.getFirstCode() : orderdetailService.findMaxCode() + 1 + "",
				baseProcessInfoService.findById(orderdetail.getProcessId()).getName());
		String currentStep=ruTaskNodeInfoService.findNameById(orderdetail.getTaskId());
		AjaxJson ajaxJson = null;
		Date date = new Date();
		String oldOpinion=orderdetail.getOpinion();
		Integer oldState=orderdetail.getState();
		if (null == orderdetailMapper.selectByPrimaryKey(orderdetail.getId())) {
			if (orderdetail.getSubmitType()) {
				runtimeService.startProcessInstanceByKey("process" + orderdetail.getProcessId(), orderdetail.getId());
				hiNodeInfoService.saveHiNodeInfo(orderdetail.getProcessId(), orderdetail.getId());
				if (!ListKit.isEmpty(hiTaskNodeInfoService.findHiTaskNodeInfosAll(orderdetail.getProcessId(),
						orderdetail.getId()))) {
					hiTaskNodeInfoService.delByHiTaskNodeInfo(orderdetail.getId());
				}
				hiTaskNodeInfoService.saveHiTaskNodeInfo(orderdetail.getProcessId(), orderdetail.getId());
				orderdetail.setState(0);
				orderdetail.setTaskId(orderdetail.getTaskId());
			}
			orderdetail.setCreateTime(date);
			orderdetail.setCreateUser(user.getId());
			orderdetail.setCurrentStep(currentStep);
			orderdetail.setStatus(0);
			int insertSelective = orderdetailMapper.insertSelective(orderdetail);
			ajaxJson = insertSelective > 0 ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, "保存失败");
		} else {
			orderdetail.setUpdateTime(date);
			orderdetail.setUpdateUser(user.getId());
			orderdetail.setStatus(0);
			orderdetail.setState(0);
			orderdetail.setOpinion(null);
			orderdetail.setCurrentStep(currentStep);
			int updateByPrimaryKeySelective = orderdetailMapper.updateByPrimaryKeySelective(orderdetail);
			ajaxJson = updateByPrimaryKeySelective > 0 ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, "修改失败");
			if (orderdetail.getSubmitType()) {
				// 此处启动流程,需要将订单id绑定到流程中
				runtimeService.startProcessInstanceByKey("process" + orderdetail.getProcessId(), orderdetail.getId());
				hiNodeInfoService.saveHiNodeInfo(orderdetail.getProcessId(), orderdetail.getId());
				hiTaskNodeInfoService.saveHiTaskNodeInfo(orderdetail.getProcessId(), orderdetail.getId());
				// 如果是回退信息从审存入回退登记表
				if (!StringUtils.isEmpty(oldOpinion) && null == oldState) {
					insertRollBackOrderInfo(orderdetail, user);
				}
			}
		}
		return ajaxJson;
	}

	@Override
	public List<Map<String, Object>> userTask(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail,
			List<Task> tasks, User user, String menuPosition) {
		List<Map<String, Object>> result = new ArrayList<>();
		// ***************************************************************************
		// 通过对象获取任务数据,将当前步骤传入
		findRunningByUser(orderdetail, tasks, menuPosition, result);
		ajaxJson.setTotal(result.size());
		// 查询所有完成和待删除的信息
		findDelAndComplete(page, rows, ajaxJson, orderdetail, user, menuPosition, result);
		// 查询保存未提交数据
		findCreateByUser(page, rows, ajaxJson, orderdetail, user, menuPosition, result);
		// 查询已办信息
		if (!StringUtils.isEmpty(menuPosition)) {
			findHiOrderdetail(page, rows, ajaxJson, orderdetail, user, menuPosition, result);
		}
		// 创建人的任务信息
		if (ruTaskNodeInfoService.findMenuByAssigne(user.getId(), user.getRefSysDepartment()).contains(menuPosition)) {
			findByCreateUser(page, rows, ajaxJson, orderdetail, user, menuPosition, result, tasks);
		}
		return result;
	}

	// 审核流程
	@Override
	@Transactional
	public AjaxJson checkOrderdetail(Orderdetail orderdetail, User user) {
		// 保存基础信息
		String accessToken = ContextHolderUtils.getRequest().getParameter("accessToken");
		AjaxJson ajaxJson = null;
		orderdetail.setUpdateTime(new Date());
		orderdetail.setUpdateUser(user.getId());
		// 查询出主要数据
		Orderdetail orderdetailServiceById = orderdetailService.findById(orderdetail.getId(), new Orderdetail());
		if (null != orderdetail.getDeliveryTime())orderdetailServiceById.setDeliveryTime(orderdetail.getDeliveryTime());
		// 此处启动流程,需要将订单id绑定到流程中
		PvmActivity nextNode = activitiService.getNextNode(orderdetail.getTaskKey());
		// 审核通过
		if (1 == orderdetail.getCheckType()) {
			ajaxJson = checkPass(orderdetail, user, accessToken, orderdetailServiceById, nextNode);
		} else {
			if (isFirstTask(orderdetail, orderdetailServiceById)) {
				ajaxJson = backToStartingPoint(orderdetail, orderdetailServiceById);
			} else {
				Boolean aBoolean = orderdetailService.updateOrderdetail(orderdetail);
				if (!aBoolean)throw new GlobalException(1, "数据保存失败,请重新审核");
				ajaxJson = activitiService.taskRollBack(orderdetail.getTaskKey(), orderdetail.getOpinion());
				hiOrderdetailService.delByOrderdetailAndTaskKey(orderdetail.getId(), orderdetail.getCurrentStep());
			}
		}
		return ajaxJson;
	}

	//检查是否为起始节点
	private boolean isFirstTask(Orderdetail orderdetail, Orderdetail orderdetailServiceById) {
		return null == orderdetail.getState() || orderdetail.getTaskId()
				.equals(hiTaskNodeInfoService
						.findHiTaskNodeInfoAll(orderdetailServiceById.getProcessId(), orderdetail.getId()).get(0)
						.getId());
	}

	//回退至未提交状态
	private AjaxJson backToStartingPoint(Orderdetail orderdetail, Orderdetail orderdetailServiceById) {
		AjaxJson ajaxJson;
		// 退回并添加审核意见
		Boolean aBoolean = orderdetailService.delFirstOrder(orderdetail.getId(),
				orderdetailServiceById.getProcessId(), orderdetail.getOpinion());
		hiNodeInfoService.delHiNodeInfoByRealProcess(orderdetail.getId());
		// 此时也需将节点信息和组件信息存入历史表中(存入逻辑同节点表相同)&&存入历史组件信息
		hiTaskNodeInfoService.delByHiTaskNodeInfo(orderdetail.getId());
		if (!aBoolean)throw new GlobalException(1, "数据保存失败,请重新审核");
		String procInstanceId = taskService.createTaskQuery().taskId(orderdetail.getTaskKey()).singleResult()
				.getProcessInstanceId();
		runtimeService.deleteProcessInstance(procInstanceId, orderdetail.getOpinion());
		// 不通过就删除完成的历史表
		hiOrderdetailService.delByOrderdetailAndTaskKey(orderdetail.getId(), orderdetail.getCurrentStep());
		ajaxJson = new AjaxJson(0, "回退成功");
		return ajaxJson;
	}

	@Transactional
	AjaxJson checkPass(Orderdetail orderdetail, User user, String accessToken, Orderdetail orderdetailServiceById,
			PvmActivity nextNode) {
		Orderdetail oldOrderdetail = new Orderdetail();
		BeanUtils.copyProperties(orderdetail, oldOrderdetail);
		orderdetail.setCurrentStep((String) nextNode.getProperty("name"));
		orderdetail.setState(1);
		if ("endEvent".equals((String) nextNode.getProperty("type"))) {
			orderdetail.setState(2);
			orderdetail.setStatus(1);
			orderdetail.setCurrentStep(oldOrderdetail.getCurrentStep() + ":" + oldOrderdetail.getTaskId());
		} else {
			saveHiOrderdetail(orderdetail, user, nextNode);
		}
		HiTaskNodeInfo taskNodeInfo = hiTaskNodeInfoService.findLikeByName((String) nextNode.getProperty("name"),
				orderdetail.getId());
		orderdetail.setTaskId(taskNodeInfo.getId());
		Boolean aBoolean = orderdetailService.updateOrderdetail(orderdetail);
		if (!aBoolean) {
			throw new GlobalException(1, "数据保存失败,请重新审核");
		}
		String procInstanceId = taskService.createTaskQuery().taskId(orderdetail.getTaskKey()).singleResult()
				.getProcessInstanceId();
		// 添加审核意见
		taskService.addComment(orderdetail.getTaskKey(), procInstanceId, orderdetail.getOpinion());
		taskService.complete(orderdetail.getTaskKey());
		// 完成审核后添加历史审核表
		HiCompleteTask hiCompleteTask = new HiCompleteTask();
		BeanUtils.copyProperties(oldOrderdetail, hiCompleteTask, "id", "createTime");
		hiCompleteTask.setId(IDUtils.getUUID());
		hiCompleteTask.setCreateTime(new Date());
		hiCompleteTaskService.insert(hiCompleteTask);
		if ("endEvent".equals((String) nextNode.getProperty("type"))) {
			AjaxJson json = business(orderdetail, accessToken, orderdetailServiceById);
			if (0 != json.getCode())
				throw new GlobalException(500, json.getMsg());
		}
		return new AjaxJson(0, "审核通过");
	}

	private void saveHiOrderdetail(Orderdetail orderdetail, User user, PvmActivity nextNode) {
		// orderdetail.setState(1);
		HiOrderdetail hiOrderdetail = new HiOrderdetail();
		BeanUtils.copyProperties(orderdetailMapper.selectByPrimaryKey(orderdetail.getId()), hiOrderdetail, "id",
				"status", "opinion");
		hiOrderdetail.setId(IDUtils.getUUID());
		hiOrderdetail.setOrderdetailId(orderdetail.getId());
		hiOrderdetail.setStatus(1);
		hiOrderdetail.setCurrentStep((String) nextNode.getProperty("name"));
		hiOrderdetail.setOperator(user.getId());
		hiOrderdetail.setTaskKey(orderdetail.getTaskKey());
		hiOrderdetail.setOpinion(orderdetail.getOpinion());
		hiOrderdetailService.save(hiOrderdetail);
	}

	private AjaxJson business(Orderdetail orderdetail, String accessToken, Orderdetail orderdetailServiceById) {
		// 此处走业务类的出入库流程,zanshi
		BaseProcessInfo baseProcessInfo = baseProcessInfoService.findById(orderdetail.getProcessId());
		if (StringUtils.isEmpty(orderdetail.getItems().get(0).getHouseNum()))
			return new AjaxJson(1, "商品数量不能为空");
		HouseBigEntrepotEntity houseBigEntrepotEntity = new HouseBigEntrepotEntity();
		houseBigEntrepotEntity.setNo(orderdetail.getId());
		houseBigEntrepotEntity.setItems(orderdetail.getItems());
		houseBigEntrepotEntity.setOutInType(ConstantMap.OUTANDINPARAMS.get(baseProcessInfo.getName()));
		houseBigEntrepotEntity.setInputDate(orderdetailServiceById.getDeliveryTime());
		houseBigEntrepotEntity.setUpdateUser(orderdetail.getUpdateUser());
		String url = base_url;
		String businessData = HttpClientUtil.lzhPost(url, houseBigEntrepotEntity);
		return JsonUtils.jsonToPojo(businessData, AjaxJson.class);
	}

	@Override
	public AjaxJson delOrderdetail(String id) {
		// 查询出信息
		Orderdetail orderdetail = orderdetailService.findById(id, new Orderdetail());
		if (!orderdetail.getSubmitType()) {
			orderdetail.setState(4);
			// 删除流程后，历史流程做逻辑删除
			//hiOrderdetailService.delByOrderdetailId(orderdetail.getId());
			Boolean aBoolean = orderdetailService.updateOrderdetail(orderdetail);
			return aBoolean ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, AjaxJson.MSGFAILURE);
		}
		// 此处走业务类的出入库流程
		Hashtable<String, String> params = delbusiness(orderdetail);
		String businessData = HttpClientUtil.get(business_url, params);
		AjaxJson json = JsonUtils.jsonToPojo(businessData, AjaxJson.class);
		if (0 != json.getCode()) {
			throw new GlobalException(1, "订单信息删除失败");
		}
		// 修改成功并且在运行中的流程,对其进行冻结
		if ("0,1".contains(orderdetail.getState() + "")) {
			String procInstanceId = taskService.createTaskQuery().taskId(orderdetail.getTaskKey()).singleResult()
					.getProcessInstanceId();
			runtimeService.deleteProcessInstance(procInstanceId, orderdetail.getOpinion());
		}
		orderdetail.setState(4);
		orderdetail.setCurrentStep("完成删除");
		// 删除流程后，历史流程做逻辑删除
		//hiOrderdetailService.delByOrderdetailId(orderdetail.getId());
		Boolean aBoolean = orderdetailService.updateOrderdetail(orderdetail);
		return aBoolean ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, AjaxJson.MSGFAILURE);
	}

	private Hashtable<String, String> delbusiness(Orderdetail orderdetail) {
		Hashtable<String, String> params = new Hashtable<>();
		String accessToken = ContextHolderUtils.getRequest().getParameter("accessToken");
		params.put("accessToken", accessToken);
		params.put("orderNo", orderdetail.getId());
		BaseProcessInfo baseProcessInfo = baseProcessInfoService.findById(orderdetail.getProcessId());
		// 流程类型
		params.put("typeName", ConstantMap.OUTANDINPARAMS.get(baseProcessInfo.getName()));
		params.put("status", "3");
		if ("0,1".contains(orderdetail.getState() + "")) {
			params.put("status", "1");
		}
		if (null != orderdetail.getDeliveryTime())
			params.put("outInTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orderdetail.getDeliveryTime()));
		return params;
	}

	private void findRunningByUser(Orderdetail orderdetail, List<Task> tasks, String menuPosition,
			List<Map<String, Object>> result) {
		tasks.forEach((Task task) -> {
			String processInstanceId = task.getProcessInstanceId();
			// 3.使用流程实例，查询
			ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
					.singleResult();
			// 4.获得流程字段id,用以获取流程字段
			String business_key = pi.getBusinessKey();
			// 获得绑定值
			Orderdetail orderdetailInfo = orderdetailService.findById(business_key, orderdetail);
			filtrationAdd(orderdetail, menuPosition, result, task, processInstanceId, orderdetailInfo);
		});
	}

	private List<Map<String, Object>> filtrationAdd(Orderdetail orderdetail, String menuPosition,
			List<Map<String, Object>> result, Task task, String processInstanceId, Orderdetail orderdetailInfo) {
		if (null != orderdetailInfo) {
			orderdetailInfo.setTaskKey(task.getId());
			orderdetailInfo.setCurrentStep(task.getName());
			// 查询节点信息（当前对应的）
			HiTaskNodeInfo byNameAndProcessId = hiTaskNodeInfoService.findByNameAndProcessId(task.getName(),
					orderdetailInfo.getProcessId(), orderdetailInfo.getId());
			// 当前任务所对应的taskId
			orderdetailInfo.setTaskId(byNameAndProcessId.getId());
			orderdetailMapper.updateByPrimaryKeySelective(orderdetailInfo);
			if (StringUtils.isEmpty(menuPosition) || (!StringUtils.isEmpty(menuPosition)
					&& menuPosition.equals(byNameAndProcessId.getMenuPosition()))) {
				Map<String, Object> map = new HashMap<>();
				List<HiHomepageHandleDesigning> homepageHandleDesignings = hiHomepageHandleDesigningService
						.findByTaskIdAndIsEnalbe(orderdetailInfo.getTaskId(), orderdetailInfo.getId());
				map.put("homepageHandleDesigning", homepageHandleDesignings);
				map.put("taskNodeInfo", hiNodeInfoService.findHiNodeInfoByRealProcess(orderdetailInfo.getId()));
				orderdetailInfo.setOperator(sysUserService.findRealNameById(orderdetailInfo.getOperator()));
				map.put("orderdetailInfo", orderdetailInfo);
				result.add(map);
			}
		}
		return result;
	}

	// 保存历史信息
	private RuTaskNodeInfo hiOrderdetail(Task task, String processInstanceId, Map<String, Object> hiMap,
			HiOrderdetail byOrderdetailAndTaskKey) {
		hiMap.put("orderdetailInfo", byOrderdetailAndTaskKey);
		// 当前任务所对应的taskId
		HomepageHandleDesigning h = new HomepageHandleDesigning();
		h.setIsEnable(1);
		h.setName("show");
		List<HomepageHandleDesigning> homepageHandleDesignings = new ArrayList<>();
		homepageHandleDesignings.add(h);
		hiMap.put("homepageHandleDesigning", homepageHandleDesignings);
		hiMap.put("taskNodeInfo",
				hiNodeInfoService.findHiNodeInfoByRealProcess(byOrderdetailAndTaskKey.getOrderdetailId()));
		RuTaskNodeInfo hiTaskInfo = ruTaskNodeInfoService.findByNameAndProcessId(task.getName(),
				byOrderdetailAndTaskKey.getProcessId());
		return hiTaskInfo;
	}

	private List<Map<String, Object>> findDelAndComplete(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail,
			User user, String menuPosition, List<Map<String, Object>> result) {
		// 获得当前人所有节点
		List<HiTaskNodeInfo> byAssigne = hiTaskNodeInfoService.findByAssigne(user.getId(), menuPosition);
		if (!ListKit.isEmpty(byAssigne)) {
			List<String> taskIds = new ArrayList<>();
			byAssigne.forEach(a -> taskIds.add(a.getId()));
			// 获得待删除的订单信息
			List<Orderdetail> byUpUserAndState = orderdetailService.findByUpUserAndState(page, rows, ajaxJson, taskIds,
					orderdetail);
			// 获得完成的信息
			List<String> currentSteps = new ArrayList<>();
			byAssigne.forEach(a -> currentSteps.add(a.getName() + ":" + a.getId()));
			List<Orderdetail> byCurrentStepAndState = orderdetailService.findByCurrentStepAndState(page, rows, ajaxJson,
					currentSteps, orderdetail);
			byUpUserAndState.addAll(byCurrentStepAndState);
			if (!ListKit.isEmpty(byUpUserAndState)) {
				byUpUserAndState.forEach(orderdetail1 -> {
					if (4 != orderdetail1.getState()) {
						Map<String, Object> map = new HashMap<>();
						orderdetail1.setOperator(sysUserService.findRealNameById(orderdetail1.getOperator()));
						map.put("orderdetailInfo", orderdetail1);
						map.put("taskNodeInfo", hiTaskNodeInfoService.findHiTaskNodeInfos(orderdetail1.getProcessId(),
								orderdetail1.getId()));
						List<HiHomepageHandleDesigning> homepageHandleDesignings = hiHomepageHandleDesigningService
								.findByTaskIdAndIsEnalbe(orderdetail1.getTaskId(), orderdetail1.getId());
						map.put("homepageHandleDesigning", homepageHandleDesignings);
						result.add(map);
					}
				});
			}
		}
		return result;
	}

	// 保存未提交数据
	private List<Map<String, Object>> findCreateByUser(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail,
			User user, String menuPosition, List<Map<String, Object>> result) {
		// 传入了菜单id就响应对应的菜单id
		List<RuTaskNodeInfo> byAssigne = ruTaskNodeInfoService.findByMenuPositionAll(menuPosition);
		if (!ListKit.isEmpty(byAssigne)) {
			// 获得节点信息
			List<String> taskIds = new ArrayList<>();
			byAssigne.forEach(ruTaskNodeInfo -> taskIds.add(ruTaskNodeInfo.getId()));
			List<Orderdetail> findByStateSave = orderdetailService.findByStateSave(page, rows, ajaxJson, taskIds,
					user.getId(), orderdetail);
			if (!ListKit.isEmpty(findByStateSave)) {
				findByStateSave.forEach(orderdetail1 -> {
					if (!(null != orderdetail1.getState() && 4 == orderdetail1.getState())) {
						Map<String, Object> map = new HashMap<>();
						orderdetail1.setOperator(sysUserService.findRealNameById(orderdetail1.getOperator()));
						map.put("orderdetailInfo", orderdetail1);
						if (orderdetail1.getSubmitType()) {
							map.put("taskNodeInfo",
									hiNodeInfoService.findHiNodeInfoByRealProcess(orderdetail1.getId()));
						} else {
							map.put("taskNodeInfo",
									ruTaskNodeInfoService.findTaskNodeInfos(orderdetail1.getProcessId()));
						}
						List<RuHomepageHandleDesigning> homepageHandleDesignings = ruHomepageHandleDeigningService
								.findByTaskIdAndIsEnalbe(orderdetail1.getTaskId());
						map.put("homepageHandleDesigning", homepageHandleDesignings);
						result.add(map);
						ajaxJson.setTotal(ajaxJson.getTotal()+1);
					}
				});
			}
		}
		return result;
	}

	// 创建人信息，显示菜单只能是新增下的菜单
	private void findByCreateUser(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail, User user,
			String menuPosition, List<Map<String, Object>> result, List<Task> tasks) {
		List<RuTaskNodeInfo> byAssigne = ruTaskNodeInfoService.findByMenuPositionAll(menuPosition);
		if (!ListKit.isEmpty(byAssigne)) {
			// 获得创建的信息
			List<Orderdetail> byCreateUser = orderdetailService.findByCreateUser(page, rows, ajaxJson, user.getId(),
					byAssigne.get(0).getProcessId(), orderdetail);
			if (!ListKit.isEmpty(byCreateUser)) {
				byCreateUser.forEach(orderdetail1 -> {
					Map<String, Object> map = new HashMap<>();
					orderdetail1.setOperator(sysUserService.findRealNameById(orderdetail1.getOperator()));
					orderdetail1.setStatus(1);
					map.put("orderdetailInfo", orderdetail1);
					map.put("taskNodeInfo", hiNodeInfoService.findHiNodeInfoByRealProcess(orderdetail1.getId()));
					// 当前任务所对应的taskId
					HomepageHandleDesigning h = new HomepageHandleDesigning();
					h.setIsEnable(1);
					h.setName("show");
					List<HomepageHandleDesigning> homepageHandleDesignings = new ArrayList<>();
					homepageHandleDesignings.add(h);
					map.put("homepageHandleDesigning", homepageHandleDesignings);
					result.add(map);
				});
			}
		}
	}

	// 根据当前登录 和菜单id查询已办信息
	public void findHiOrderdetail(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail, User user,
			String menuPosition, List<Map<String, Object>> result) {
		List<HiTaskNodeInfo> hiTaskNodeInfos = hiTaskNodeInfoService.findByAssigne(user.getId(), menuPosition);
		if (!ListKit.isEmpty(hiTaskNodeInfos)) {
			List<String> taskIds = new ArrayList<>();
			hiTaskNodeInfos.forEach(hiTaskNodeInfo -> taskIds.add(hiTaskNodeInfo.getId()));
			List<HiOrderdetail> hiOrderdetails = hiOrderdetailService.findHiOrderdetail(page, rows, ajaxJson,
					orderdetail, taskIds);
			hiOrderdetails.forEach(a -> {
				Map<String, Object> map = new HashMap<>();
				a.setOperator(sysUserService.findRealNameById(a.getOperator()));
				map.put("orderdetailInfo", a);
				// 当前任务所对应的taskId
				HomepageHandleDesigning h = new HomepageHandleDesigning();
				h.setIsEnable(1);
				h.setName("show");
				List<HomepageHandleDesigning> homepageHandleDesignings = new ArrayList<>();
				homepageHandleDesignings.add(h);
				map.put("homepageHandleDesigning", homepageHandleDesignings);
				map.put("taskNodeInfo", hiNodeInfoService.findHiNodeInfoByRealProcess(a.getOrderdetailId()));
				result.add(map);
			});
		}
	}

	@Override
	public AjaxJson auditDelete(Orderdetail orderdetail, User user) {
		Orderdetail byId = orderdetailService.findById(orderdetail.getId(), new Orderdetail());
		byId.setUpdateTime(new Date());
		List<HiTaskNodeInfo> taskNodeInfos = hiTaskNodeInfoService.findHiTaskNodeInfosAll(byId.getProcessId(),
				orderdetail.getId());
		HiOrderdetail hiOrderdetail = new HiOrderdetail();
		BeanUtils.copyProperties(byId, hiOrderdetail, "id", "status");
		hiOrderdetail.setId(IDUtils.getUUID());
		hiOrderdetail.setOrderdetailId(byId.getId());
		hiOrderdetail.setStatus(1);
		hiOrderdetail.setState(3);
		hiOrderdetail.setOperator(user.getId());
		hiOrderdetail.setOpinion(orderdetail.getOpinion());
		hiOrderdetail.setTaskId(byId.getCurrentStep().split(":")[1]);
		hiOrderdetailService.save(hiOrderdetail);
		HiTaskNodeInfo delNode = null;
		// 找到最后一步流程
		for (HiTaskNodeInfo taskNodeInfo : taskNodeInfos) {
			if (taskNodeInfo.getName().contains("删除")) {
				delNode = taskNodeInfo;
			}
		}
		byId.setTaskId(delNode.getId());
		byId.setState(3);
		byId.setCurrentStep("等待删除");
		// 确认删除人员
		byId.setDelUser(delNode.getAssignee());
		byId.setUpdateUser(user.getId());
		byId.setOpinion(orderdetail.getOpinion());
		Boolean aBoolean = orderdetailService.updateOrderdetail(byId);
		return aBoolean ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, AjaxJson.MSGFAILURE);
	}
	
	private void insertRollBackOrderInfo(Orderdetail orderdetail, User user) {
		RollBackOrderInfo rollBackOrderInfo = new RollBackOrderInfo();
		rollBackOrderInfo.setId(IDUtils.getUUID());
		rollBackOrderInfo.setCreateTime(new Date());
		rollBackOrderInfo.setCreateUser(user.getId());
		rollBackOrderInfo.setProcessId(orderdetail.getProcessId());
		rollBackOrderInfo.setOrderdetailId(orderdetail.getId());
		rollBackOrderInfoMapper.insert(rollBackOrderInfo);
	}
}
