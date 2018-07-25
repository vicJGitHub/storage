package com.hywa.bigdata.storage.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.User;

public interface WorkFlowService {

	AjaxJson saveOrderdetail(Orderdetail orderdetail, User user) throws ParseException;

    List<Map<String, Object>> userTask(int page,int rows,AjaxJson ajaxJson,Orderdetail orderdetail, List<Task> tasks, User user,
			String menuPosition);

    AjaxJson checkOrderdetail(Orderdetail orderdetail,User user);

    AjaxJson delOrderdetail(String id);
    
    AjaxJson auditDelete(Orderdetail orderdetail,User user);
}
