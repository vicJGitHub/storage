package com.hywa.bigdata.storage.controller;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.controller.validate.processValidate.DelProcessValidate;
import com.hywa.bigdata.storage.controller.validate.processValidate.DeployValidate;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.service.ActivitiService;
import com.hywa.bigdata.storage.service.BaseProcessInfoService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import com.hywa.bigdata.storage.validate.JsonValidate;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping("process")
@RestController
public class ProcessController {

    @Autowired
    ActivitiService activitiService;

    @Autowired
    TaskNodeInfoService taskNodeInfoService;

    @Autowired
    BaseProcessInfoService baseProcessInfoService;

    //构建动态模型并进行部署,根据前段数据定义流程
    @RequestMapping("deploy")
    @JsonValidate(DeployValidate.class)
    public AjaxJson deploy(@RequestParam(name = "id") String baseProcessInfoId) throws IOException {
        BaseProcessInfo baseProcessInfo = baseProcessInfoService.findById(baseProcessInfoId);
        List<TaskNodeInfo> taskNodeInfos = taskNodeInfoService.findTaskNodeInfoAll(baseProcessInfoId);
        //生成自定义流程并进行部署,并返回部署后的流程信息
        Deployment deploy = activitiService.deploy(baseProcessInfo, taskNodeInfos);
        return null != deploy ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, AjaxJson.MSGFAILURE);
    }

}
