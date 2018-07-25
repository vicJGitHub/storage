package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;

public class OrderCompileWinValidate extends Validator<String> {

    @Override
    public AjaxJson validate(String id) {
        if (StringUtils.isEmpty(id)) {
            return new AjaxJson(1, "订单id不能为空");
        }
        return null;
    }
}
