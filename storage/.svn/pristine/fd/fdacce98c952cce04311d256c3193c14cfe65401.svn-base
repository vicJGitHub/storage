package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.HiOrderHandleDesigningMapper;
import com.hywa.bigdata.storage.mapper.OrderHandleDesigningMapper;
import com.hywa.bigdata.storage.mapper.RuOrderHandleDesigningMapper;
import com.hywa.bigdata.storage.service.HiOrderHandleDesigningService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HiOrderHandleDesigningServiceImpl implements HiOrderHandleDesigningService {

    @Autowired
    HiOrderHandleDesigningMapper hiOrderHandleDesigningMapper;

    @Autowired
    RuOrderHandleDesigningMapper ruOrderHandleDesigningMapper;

    @Override
    public List<HiOrderHandleDesigning> findOrderHandleDesigning(String taskId) {
        HiOrderHandleDesigningExample HiOrderHandleDesigningExample = new HiOrderHandleDesigningExample();
        HiOrderHandleDesigningExample.Criteria criteria = HiOrderHandleDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        criteria.andIsEnableEqualTo(1);
        HiOrderHandleDesigningExample.setOrderByClause("sort");
        return hiOrderHandleDesigningMapper.selectByExample(HiOrderHandleDesigningExample);
    }

    //历史组件
    @Override
    public int saveHiOrderHandleDesigning(String taskId,String hiTaskId, String RealProcess) {
        RuOrderHandleDesigningExample ruOrderFieldDesigningExample = new RuOrderHandleDesigningExample();
        ruOrderFieldDesigningExample.createCriteria().andTaskIdEqualTo(taskId);
        List<RuOrderHandleDesigning> orderHandleDesignings = ruOrderHandleDesigningMapper.selectByExample(ruOrderFieldDesigningExample);
        List<HiOrderHandleDesigning> hiOrderHandleDesignings=new ArrayList<>();
        orderHandleDesignings.forEach(orderHandleDesigning->{
            HiOrderHandleDesigning hiOrderHandleDesigning = new HiOrderHandleDesigning();
            BeanUtils.copyProperties(orderHandleDesigning,hiOrderHandleDesigning);
            hiOrderHandleDesigning.setId(IDUtils.getUUID());
            hiOrderHandleDesigning.setRealProcess(RealProcess);
            hiOrderHandleDesigning.setCreateTime(new Date());
            hiOrderHandleDesigning.setTaskId(hiTaskId);
            hiOrderHandleDesignings.add(hiOrderHandleDesigning);
        });
        return hiOrderHandleDesigningMapper.insertBatch(hiOrderHandleDesignings);
    }
    
    public int delHiOrderHandleDesigning(String taskId) {
    	HiOrderHandleDesigningExample hiOrderHandleDesigningExample = new HiOrderHandleDesigningExample();
    	HiOrderHandleDesigningExample.Criteria criteria = hiOrderHandleDesigningExample.createCriteria();
                        criteria.andTaskIdEqualTo(taskId);
            return hiOrderHandleDesigningMapper.deleteByExample(hiOrderHandleDesigningExample );
        }
}
