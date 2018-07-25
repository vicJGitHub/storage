package com.hywa.bigdata.storage.service;


import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.HiTaskNodeInfo;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 任务节点信息 服务类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
public interface HiTaskNodeInfoService {

    AjaxJson saveHiTaskNodeInfo(HiTaskNodeInfo HiTaskNodeInfo, User user);


    List<HiTaskNodeInfo> findHiTaskNodeInfos(String processId, String realProcess);

    List<HiTaskNodeInfo> findHiTaskNodeInfoAll(String processId, String realProcess);

    HiTaskNodeInfo findByMenuPosition(String menuPosition, String realProcess);

    AjaxJson saveBatchHiTaskNodeInfo(List<HiTaskNodeInfo> HiTaskNodeInfo, User user);

    HiTaskNodeInfo findById(String id);

    HiTaskNodeInfo findLikeByName(String name, String orderdetailId);

    List<HiTaskNodeInfo> findAllByProcessId(String processId, String taskId, String realProcess);

    HiTaskNodeInfo findByNameAndProcessId(String name, String processId, String realProcess);

    List<HiTaskNodeInfo> findByAssigne(String assignee,String menuPosition);
    
    List<HiTaskNodeInfo> findByMenuPositionAll(String menuPosition, String realProcess);
    
    List<String> findMenuByAssigne(String assignee, String realProcess);

    String findNameById(String id);

    int saveHiTaskNodeInfo(String processId, String realProcess);
    
    int delByHiTaskNodeInfo(String oldOrderdetailId);
    
    List<String> findCurrentStep(String processId);
    
    List<HiTaskNodeInfo> findByMenuPositionOne(String menuPosition);
    
    List<HiTaskNodeInfo> findHiTaskNodeInfosAll(String processId, String realProcess);
    
    List<HiTaskNodeInfo> findDelAndComplete(String assignee,String department);
}
