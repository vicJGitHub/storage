package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.SpringContext;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.service.OrderdetailService;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class DelOrderdetailValidate extends Validator<String> {

    @Override
    public AjaxJson validate(String id) {
        if (StringUtils.isEmpty(id)) {
            return new AjaxJson(1, "id不能为空");
        }
        //需要先判断该流程的状态
        OrderdetailService orderdetailService=(OrderdetailService)SpringContext.getBean("orderdetailServiceImpl");
        Orderdetail orderdetail = orderdetailService.findById(id, new Orderdetail());
        Integer state = orderdetail.getState();
        if (null!=state&&2 == state) {
            return new AjaxJson(1, "需确认删除后才可进行删除操作");
        }
        return null;
    }
}
