package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.HiOrderFieldDesigningMapper;
import com.hywa.bigdata.storage.mapper.OrderFieldDesigningMapper;
import com.hywa.bigdata.storage.mapper.RuOrderFieldDesigningMapper;
import com.hywa.bigdata.storage.service.HiOrderFieldDesigningService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HiOrderFieldDesigningServiceImpl implements HiOrderFieldDesigningService {

    @Autowired
    HiOrderFieldDesigningMapper hiOrderFieldDesigningMapper;

    @Autowired
    RuOrderFieldDesigningMapper ruOrderFieldDesigningMapper;

    public Boolean saveHiOrderFieldDesigning(HiOrderFieldDesigning HiOrderFieldDesigning){
        int result=hiOrderFieldDesigningMapper.insert(HiOrderFieldDesigning);
        return result>0?true:false;
    }

    @Override
    public List<HiOrderFieldDesigning> findOrderFieldDesigning(String taskId) {
        HiOrderFieldDesigningExample HiOrderFieldDesigningExample = new HiOrderFieldDesigningExample();
        HiOrderFieldDesigningExample.Criteria criteria = HiOrderFieldDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        return hiOrderFieldDesigningMapper.selectByExample(HiOrderFieldDesigningExample);
    }

    //历史组件
    @Override
    public int saveHiOrderFieldDesigning(String taskId,String hiTaskId, String RealProcess) {
        RuOrderFieldDesigningExample ruOrderFieldDesigningExample = new RuOrderFieldDesigningExample();
       ruOrderFieldDesigningExample.createCriteria().andTaskIdEqualTo(taskId);
        List<RuOrderFieldDesigning> orderFieldDesignings = ruOrderFieldDesigningMapper.selectByExample(ruOrderFieldDesigningExample);
        List<HiOrderFieldDesigning> hiOrderFieldDesignings=new ArrayList<>();
        orderFieldDesignings.forEach(orderFieldDesigning->{
            HiOrderFieldDesigning hiOrderFieldDesigning = new HiOrderFieldDesigning();
            BeanUtils.copyProperties(orderFieldDesigning,hiOrderFieldDesigning);
            hiOrderFieldDesigning.setId(IDUtils.getUUID());
            hiOrderFieldDesigning.setRealProcess(RealProcess);
            hiOrderFieldDesigning.setCreateTime(new Date());
            hiOrderFieldDesigning.setTaskId(hiTaskId);
            hiOrderFieldDesignings.add(hiOrderFieldDesigning);
        });
        return hiOrderFieldDesigningMapper.insertBatch(hiOrderFieldDesignings);
    }
    
    public int delHiOrderFieldDesigning(String taskId) {
        HiOrderFieldDesigningExample hiOrderFieldDesigningExample = new HiOrderFieldDesigningExample();
        HiOrderFieldDesigningExample.Criteria criteria = hiOrderFieldDesigningExample.createCriteria();
                        criteria.andTaskIdEqualTo(taskId);
            return hiOrderFieldDesigningMapper.deleteByExample(hiOrderFieldDesigningExample );
        }
}