package com.hywa.bigdata.storage.controller.validate.windowsInfoValidate;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.common.SpringContext;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.service.HomepageHandleDesigningService;
import com.hywa.bigdata.storage.service.OrderFieldDesigningService;
import com.hywa.bigdata.storage.service.OrderHandleDesigningService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import com.hywa.bigdata.storage.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

public class SaveAndUpdateBaseProcessInfoValidate extends Validator<BaseProcessInfo> {

    @Override
    public AjaxJson validate(BaseProcessInfo baseProcessInfo) {
        //验证启用禁用状态,没有配置节点不能是启用状态
        if (StringUtils.isEmpty(baseProcessInfo.getId())) {
            return new AjaxJson(1, "流程id不能为空,暂不支持新增");
        }
        if (1 == baseProcessInfo.getIsStartUsing()) {
            TaskNodeInfoService taskNodeInfoService = (TaskNodeInfoService) SpringContext.getBean("taskNodeInfoServiceImpl");
            List<TaskNodeInfo> taskNodeInfoAll = taskNodeInfoService.findTaskNodeInfoAll(baseProcessInfo.getId());
            if (ListKit.isEmpty(taskNodeInfoAll)) {
                return new AjaxJson(1, "未配置流程下的节点,无法启动流程");
            } else {
                for (int i = 0; i < taskNodeInfoAll.size(); i++) {
                    TaskNodeInfo taskNodeInfo = taskNodeInfoAll.get(i);//判断节点下是否配置了表单
                    HomepageHandleDesigningService homepageHandleDesigningService = (HomepageHandleDesigningService) SpringContext.getBean("homepageHandleDesigningServiceImpl");
                    if (ListKit.isEmpty(homepageHandleDesigningService.findByTaskId(taskNodeInfo.getId()))) {
                        return new AjaxJson(1, "必须配置节点下的主页设计信息");
                    }
                    OrderHandleDesigningService orderHandleDesigningService = (OrderHandleDesigningService) SpringContext.getBean("orderHandleDesigningServiceImpl");
                    if (ListKit.isEmpty(orderHandleDesigningService.findOrderHandleDesigning(taskNodeInfo.getId()))) {
                        return new AjaxJson(1, "必须配置节点下的办理页操作信息");
                    }
                    OrderFieldDesigningService orderFieldDesigningService = (OrderFieldDesigningService) SpringContext.getBean("orderFieldDesigningServiceImpl");
                    if (ListKit.isEmpty(orderFieldDesigningService.findOrderFieldDesigning(taskNodeInfo.getId()))) {
                        return new AjaxJson(1, "必须配置节点下的办理页显示信息");
                    }
                }
            }
        }
        return null;
    }
}
