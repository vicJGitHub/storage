package com.hywa.bigdata.storage.service;


import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.RuTaskNodeInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;

/**
 * <p>
 * 运行任务节点信息 服务类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
public interface RuTaskNodeInfoService {

    List<RuTaskNodeInfo> findTaskNodeInfos(String processId);

    RuTaskNodeInfo findByMenuPosition(String menuPosition);

    RuTaskNodeInfo findById(String id);

    List<RuTaskNodeInfo> findAllByProcessId(String processId, String taskId);

    Boolean updateRuTaskInfo(String processId);
    
    String findNameById(String id);
    
    RuTaskNodeInfo findByNameAndProcessId(String name,String processId);
    
    List<String> findMenuByAssigne(String assignee,String department);
    
    List<RuTaskNodeInfo> findByMenuPositionAll(String menuPosition);
}
