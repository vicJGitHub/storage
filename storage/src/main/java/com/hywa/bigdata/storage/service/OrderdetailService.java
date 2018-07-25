package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.SysUser;
import com.hywa.bigdata.storage.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderdetailService {


    List<Orderdetail> findByProcessId(String processId);

    Boolean updateOrderdetail(Orderdetail orderdetail);

    //此处还需添加条件查询的方式
    Orderdetail findById(String id, Orderdetail orderdetail);

    //根据修改人和state查询
    List<Orderdetail> findByUpUserAndState(int page, int rows, AjaxJson ajaxJson, List<String> taskIds, Orderdetail orderdetail);


    List<Orderdetail> findByCurrentStepAndState(int page, int rows, AjaxJson ajaxJson, List<String> currentSteps, Orderdetail orderdetail);

    List<Map<String, Object>> findUnfinished(User user);
    
    Map<String, Object> findUnfinishedByProcessId(Map<String, Object> map,User user);

    Map<String, Object> adminUserTask();

    List<SysUser> findOperatorAll(String processId);

    List<Orderdetail> findByCreateUser(int page, int rows, AjaxJson ajaxJson, String createUser, String processId, Orderdetail orderdetail);

    List<Orderdetail> findByStateSave(int page, int rows, AjaxJson ajaxJson, List<String> taskIds, String createUser, Orderdetail orderdetail);

    boolean isEmpty();

    Long findMaxCode();

    boolean delFirstOrder(String id, String processId, String opinion);

    Map<String, Object> findAllCheckPendingOrder(Map<String, Object> map,User user);
    
    boolean checkTrackingNumber(String trackingNumber);
}
