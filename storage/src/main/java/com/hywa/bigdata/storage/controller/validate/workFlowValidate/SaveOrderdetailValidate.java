package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.SpringContext;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.service.BaseProcessInfoService;
import com.hywa.bigdata.storage.validate.Validator;

public class SaveOrderdetailValidate extends Validator<Orderdetail> {
    @Override
    public AjaxJson validate(Orderdetail orderdetail) {
        if (orderdetail.getSubmitType()) {
            BaseProcessInfoService baseProcessInfoService = (BaseProcessInfoService) SpringContext.getBean("baseProcessInfoServiceImpl");
            BaseProcessInfo baseProcessInfo = baseProcessInfoService.findById(orderdetail.getProcessId());
            if(0==baseProcessInfo.getIsStartUsing()){
                return new AjaxJson(1,"该流程未启动无法提交");
            }

        }

        return null;
    }
}
