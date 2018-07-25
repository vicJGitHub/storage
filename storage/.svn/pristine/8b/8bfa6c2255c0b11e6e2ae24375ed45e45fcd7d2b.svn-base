package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;

public class AuditDeleteValidate extends Validator<Orderdetail> {
    @Override
    public AjaxJson validate(Orderdetail orderdetail) {
        if (StringUtils.isEmpty(orderdetail.getId())) {
            return new AjaxJson(1, "订单id不能为空");
        }
        return null;
    }
}
