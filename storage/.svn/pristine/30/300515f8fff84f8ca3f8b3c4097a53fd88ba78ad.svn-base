package com.hywa.bigdata.storage.controller.validate.workFlowValidate;

import org.springframework.util.StringUtils;
import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.SpringContext;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.service.RuTaskNodeInfoService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import com.hywa.bigdata.storage.validate.Validator;

public class OrderSaveValidate extends Validator<String> {
    @Override
    public AjaxJson validate(String menuPosition) {
        if (StringUtils.isEmpty(menuPosition)) {
            return new AjaxJson(1, "菜单位置信息不能为空");
        }
            TaskNodeInfoService taskNodeInfoService = (TaskNodeInfoService) SpringContext.getBean("taskNodeInfoServiceImpl");
        TaskNodeInfo taskNodeInfo = taskNodeInfoService.findByMenuPosition(menuPosition);
        if (null == taskNodeInfo) {
            return new AjaxJson(1, "该菜单下不存在新增业务");
        }
        RuTaskNodeInfoService ruTaskNodeInfoService = (RuTaskNodeInfoService) SpringContext.getBean("ruTaskNodeInfoServiceImpl");
        if(null==ruTaskNodeInfoService.findByMenuPosition(menuPosition)) {
        	return new AjaxJson(1, "该流程未启动");
        };
        return null;
    }
}
