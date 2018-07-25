package com.hywa.bigdata.storage.service;


import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;

/**
 * <p>
 * 任务节点信息 服务类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
public interface TaskNodeInfoService {

    AjaxJson saveTaskNodeInfo(TaskNodeInfo taskNodeInfo,User user);

    AjaxJson updateTaskNodeInfo(TaskNodeInfo taskNodeInfo,User user);

    AjaxJson delTaskNodeInfo(String taskId);

    List<TaskNodeInfo> findTaskNodeInfos(String processId);

    List<TaskNodeInfo> findTaskNodeInfoAll(String processId);

    TaskNodeInfo findByMenuPosition(String menuPosition);

    AjaxJson saveBatchTaskNodeInfo(List<TaskNodeInfo> taskNodeInfo,User user);

    TaskNodeInfo findById(String id);

    List<TaskNodeInfo> findAllByProcessId(String processId,String taskId);

    TaskNodeInfo findByNameAndProcessId(String name,String processId);

    List<TaskNodeInfo> findByAssigne(String assigne);
    
    List<TaskNodeInfo> findByMenuPositionAll(String menuPosition);
    
    List<String> findMenuByAssigne(String assignee,String department);

    String findNameById(String id);
}
