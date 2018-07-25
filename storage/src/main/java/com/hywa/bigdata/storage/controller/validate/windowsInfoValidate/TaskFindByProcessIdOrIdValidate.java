package com.hywa.bigdata.storage.controller.validate.windowsInfoValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;

public class TaskFindByProcessIdOrIdValidate extends Validator<String> {
    @Override
    public AjaxJson validate(String s) {
        if (StringUtils.isEmpty(s)) {
            return new AjaxJson(1, "流程id不能为空");
        }
        return null;
    }
}
