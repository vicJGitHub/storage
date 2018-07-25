package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import org.springframework.util.StringUtils;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.validate.Validator;

public class FindNodeInfoByProcessIdValidate extends Validator<String> {

    @Override
    public AjaxJson validate(String processId) {
        if (StringUtils.isEmpty(processId)) {
            return new AjaxJson(1, "流程Id不能为空");
        }
        return null;
    }
}
