package com.hywa.bigdata.storage.service.impl;

import com.github.pagehelper.PageHelper;
import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.BaseProcessInfoMapper;
import com.hywa.bigdata.storage.mapper.OrderdetailMapper;
import com.hywa.bigdata.storage.service.BaseProcessInfoService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class BaseProcessInfoServiceImpl implements BaseProcessInfoService {

    @Autowired
    BaseProcessInfoMapper baseProcessInfoMapper;

    @Autowired
    TaskNodeInfoService taskNodeInfoService;

    @Autowired
    OrderdetailMapper orderdetailMapper;

    @Override
    public Boolean saveBaseProcessInfo(BaseProcessInfo baseProcessInfo) {
        int result = baseProcessInfoMapper.insert(baseProcessInfo);
        return result > 0 ? true : false;
    }

    @Override
    public Boolean updateBaseProcessInfo(BaseProcessInfo baseProcessInfo) {
        int result = baseProcessInfoMapper.updateByPrimaryKey(baseProcessInfo);
        return result > 0 ? true : false;
    }

    //条件查询流程,分页查询
    @Override
    public List<BaseProcessInfo> findBaseProcessInfo(BaseProcessInfo baseProcessInfo,Integer page,Integer rows) {
        //根据类型,名称进行搜索
        PageHelper.startPage(page, rows,"orderNumber");
        BaseProcessInfoExample baseProcessInfoExample = new BaseProcessInfoExample();
        BaseProcessInfoExample.Criteria criteria = baseProcessInfoExample.createCriteria();
        if (!StringUtils.isEmpty(baseProcessInfo.getType())) {
            criteria.andTypeLike("%"+baseProcessInfo.getType()+"%");
        }
        if (!StringUtils.isEmpty(baseProcessInfo.getName())) {
            criteria.andNameLike("%"+baseProcessInfo.getName()+"%");
        }
        return baseProcessInfoMapper.selectByExample(baseProcessInfoExample);
    }

    //根据id查询
    @Override
    public BaseProcessInfo findById(String id) {
        return baseProcessInfoMapper.selectByPrimaryKey(id);
    }

    //启用禁用
    @Override
    public AjaxJson enableDisable(String processId,User user) {
        BaseProcessInfo baseProcessInfo = baseProcessInfoMapper.selectByPrimaryKey(processId);
        Integer isStartUsing = baseProcessInfo.getIsStartUsing();
        isStartUsing = 1 == isStartUsing ? 0 : 1;
        //未配置完信息无法启用
        if (1 == baseProcessInfo.getIsStartUsing()) {
            List<TaskNodeInfo> taskNodeInfoAll = taskNodeInfoService.findTaskNodeInfoAll(baseProcessInfo.getId());
            if (ListKit.isEmpty(taskNodeInfoAll)) {
                return new AjaxJson(1, "未配置流程下的节点,无法启动流程");
            }
        }
        //流程运行中无法禁用
        if (1 == baseProcessInfo.getIsStartUsing()) {
            OrderdetailExample orderdetailExample = new OrderdetailExample();
            OrderdetailExample.Criteria criteria = orderdetailExample.createCriteria();
            criteria.andStateIn(Arrays.asList(0, 1));
            List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(orderdetailExample);
            if (!ListKit.isEmpty(orderdetails)) return new AjaxJson(1, "存在运行中流程,无法禁用");
        }
        baseProcessInfo.setIsStartUsing(isStartUsing);
        baseProcessInfo.setUpdateUser(user.getId());
        baseProcessInfo.setUpdateTime(new Date());
        int result = baseProcessInfoMapper.updateByPrimaryKeySelective(baseProcessInfo);
        return result > 0 ? new AjaxJson(0, AjaxJson.MSGSUCCESS) : new AjaxJson(1, AjaxJson.MSGFAILURE);
    }
}
