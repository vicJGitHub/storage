package com.hywa.bigdata.storage.controller.validate.processValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;


public class DelProcessValidate extends Validator<String> {

    @Override
    public AjaxJson validate(String processId) {
        //拉取对应方法的参数
        if (StringUtils.isEmpty((String)processId)) {
            return new AjaxJson(1,"流程id不能为空");
        }
        return null;
    }


}
