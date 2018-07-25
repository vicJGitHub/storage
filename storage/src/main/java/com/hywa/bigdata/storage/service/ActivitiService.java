package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.repository.Deployment;

import java.io.IOException;
import java.util.List;


public interface ActivitiService {

    //构建动态模型(返回流程id)
    Deployment deploy(BaseProcessInfo baseProcessInfo, List<TaskNodeInfo> taskNodeInfos) throws IOException;

    //删除流程(第二个参数代表是否级联删除)
    AjaxJson delDeploy(String processId, Boolean b);

    //回退方法
    AjaxJson taskRollBack(String taskId,String opinion);

    //根据当前任务获取下个任务信息
    PvmActivity getNextNode(String taskId);

}
