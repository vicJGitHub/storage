package com.hywa.bigdata.storage.controller.validate.windowsInfoValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.util.StringUtils;

public class DesignOrderFindByTaskIdValidate extends Validator<String> {
    @Override
    public AjaxJson validate(String taskId) {
        if (StringUtils.isEmpty(taskId)) {
            return new AjaxJson(1, "节点id不能为空");
        }
        return null;
    }
}
