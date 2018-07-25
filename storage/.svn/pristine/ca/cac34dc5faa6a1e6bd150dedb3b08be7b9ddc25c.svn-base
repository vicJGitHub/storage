package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;

public class CheckOrderdetailValidate extends Validator<Orderdetail> {

    @Override
    public AjaxJson validate(Orderdetail orderdetail) {
        if (StringUtils.isEmpty(orderdetail.getId())) {
            return new AjaxJson(1, "订单id不能为空");
        }
        if (null == orderdetail.getCheckType()) {
            return new AjaxJson(1, "必须给定审核状态");
        }
        return null;
    }
}
