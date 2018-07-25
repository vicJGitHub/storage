package com.hywa.bigdata.storage.controller;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.common.redis.RedisUser;
import com.hywa.bigdata.storage.controller.validate.windowsInfoValidate.DesignHomePageFindByTaskIdValidate;
import com.hywa.bigdata.storage.controller.validate.windowsInfoValidate.DesignOrderFindByTaskIdValidate;
import com.hywa.bigdata.storage.controller.validate.windowsInfoValidate.TaskFindByProcessIdOrIdValidate;
import com.hywa.bigdata.storage.controller.validate.workFlowValidate.DesignHomePageValidate;
import com.hywa.bigdata.storage.controller.validate.workFlowValidate.DesignOrderValidate;
import com.hywa.bigdata.storage.controller.validate.workFlowValidate.SaveAndUpdateTaskNodeInfoValidate;
import com.hywa.bigdata.storage.controller.validate.workFlowValidate.SaveBatchTaskNodeInfoFValidate;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.entity.vo.VoTaskNodeInfo;
import com.hywa.bigdata.storage.service.*;
import com.hywa.bigdata.storage.validate.JsonValidate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

//自定义窗口信息
@RestController
@RequestMapping("windowsInfo")
public class WindowsInfoController {

    @Autowired
    SysDepartmentService sysDepartmentService;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    TaskNodeInfoService taskNodeInfoService;

    @Autowired
    RedisUser redisUser;

    @Autowired
    BaseProcessInfoService baseProcessInfoService;

    @Autowired
    WindowsInfoService windowsInfoService;


    @Autowired
    SysPermissionService sysPermissionService;
    
    @Autowired
    TemplHomepageHandleDesigningService templHomepageHandleDesigningService;
    
    //条件查询流程
    @RequestMapping("findBaseProcessInfo")
    public AjaxJson findBaseProcessInfo(BaseProcessInfo baseProcessInfo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
        return new AjaxJson(baseProcessInfoService.findBaseProcessInfo(baseProcessInfo, page, rows));
    }

    //根据id查询流程(暂时不用)
    @RequestMapping("findBaseProcessInfoById")
    public AjaxJson findBaseProcessInfoById(String id) {
        return new AjaxJson(baseProcessInfoService.findById(id));
    }

    //显示部门信息或是部门下人员信息
    @RequestMapping("getUserByDepartment")
    public AjaxJson getUserByDepartment() {
            List<SysDepartment> sysDepartments = sysDepartmentService.findAll();
            List<Map<String, Object>> list = new ArrayList<>();
            sysDepartments.forEach(sysDepartment -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", sysDepartment.getGuid());
                map.put("name", sysDepartment.getCname());
                map.put("code", sysDepartment.getCcode());
                map.put("children",sysUserService.findByDepartment(sysDepartment.getGuid()));
                list.add(map);
         });
            return new AjaxJson(list);
        }

    //查询所属菜单
    @RequestMapping("findMenu")
    public AjaxJson findMenu(@RequestParam(name = "id", defaultValue = "#") String parentId) {
         List<SysPermission> byParentId = sysPermissionService.findByParentId(parentId);
         //需要返回是否是叶子节点
         List<Map<String, Object>> list = new ArrayList<>();
         byParentId.forEach(sysPermission -> {
             Map<String, Object> map = new HashMap<>();
             List<SysPermission> byParentId1 = sysPermissionService.findByParentId(sysPermission.getGUID());
             map.put("isLeafNode", ListKit.isEmpty(byParentId1) ? true : false);
             map.put("id", sysPermission.getGUID());
             map.put("name",sysPermission.getCNAME());
             map.put("url", sysPermission.getURL());
             if("1".equals(sysPermission.getISPROCESS()))list.add(map);
         });
         return new AjaxJson(list);
    }


    //批量保存节点信息
    @RequestMapping(value="saveBatchTaskNodeInfo",consumes = "application/json;charset=utf-8")
    @JsonValidate(SaveBatchTaskNodeInfoFValidate.class)
    public AjaxJson saveBatchTaskNodeInfo(@RequestBody @Valid BatchTaskNodeInfo batchTaskNodeInfo, BindingResult bindingResult) {
        //保存节点信息(保存节点任务)
        User user = redisUser.getUser();
        return taskNodeInfoService.saveBatchTaskNodeInfo(batchTaskNodeInfo.getTaskNodeInfo(), user);
    }

    //根据流程id显示节点信息
    @RequestMapping("taskFindByProcessIdOrId")
    @JsonValidate(TaskFindByProcessIdOrIdValidate.class)
    public AjaxJson taskFindById(String processId,String taskId) {
        List<TaskNodeInfo> allByProcessId = taskNodeInfoService.findAllByProcessId(processId, taskId);
        allByProcessId.forEach(taskNodeInfo -> {
        	if(!StringUtils.isEmpty(taskNodeInfo.getDepartment())) taskNodeInfo.setDepartment(sysDepartmentService.findInfoById(taskNodeInfo.getDepartment()));
        	if(!StringUtils.isEmpty(taskNodeInfo.getAssignee()))taskNodeInfo.setAssignee(sysUserService.findInfoById(taskNodeInfo.getAssignee()));
        	taskNodeInfo.setMenuName(sysPermissionService.findNameById(taskNodeInfo.getMenuPosition()));
        });
        return new AjaxJson(allByProcessId);
    }

    //根据taskId查询自定义表单
    @RequestMapping("designHomePageFindByTaskId")
    @JsonValidate(DesignHomePageFindByTaskIdValidate.class)
    public AjaxJson designHomePageFindByTaskId(String taskId) {
    	List<HomepageHandleDesigning> list=windowsInfoService.designHomePageFindByTaskId(taskId);
        return ListKit.isEmpty(list)?new AjaxJson(templHomepageHandleDesigningService.findAll(taskId))
        		:new AjaxJson(list);
    }

    //设计自定义表单
    @RequestMapping("designHomePage")
    @JsonValidate(DesignHomePageValidate.class)
    public AjaxJson designHomePage( @RequestBody DesignHomePageInfo designHomePageInfo) {
        User user = redisUser.getUser();
        return windowsInfoService.designHomePage(designHomePageInfo, user);
    }

    //根据taskId查询设计办理页表单
    @RequestMapping("designOrderFindByTaskId")
    @JsonValidate(DesignOrderFindByTaskIdValidate.class)
    public AjaxJson designOrderFindByTaskId(String taskId) {
        return new AjaxJson(windowsInfoService.designOrderFindByTaskId(taskId));
    }

    //设计办理页表单
    @RequestMapping("designOrder")
    @JsonValidate(DesignOrderValidate.class)
    public AjaxJson designOrder(@RequestBody OrderDesigningInfo orderDesigningInfo) {
        User user = redisUser.getUser();
        windowsInfoService.designOrder(orderDesigningInfo, user);
        return new AjaxJson(0, AjaxJson.MSGSUCCESS);
    }

}

