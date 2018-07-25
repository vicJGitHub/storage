package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.OrderFieldDesigning;
import com.hywa.bigdata.storage.entity.OrderFieldDesigningExample;
import com.hywa.bigdata.storage.mapper.OrderFieldDesigningMapper;
import com.hywa.bigdata.storage.service.OrderFieldDesigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFieldDesigningServiceImpl implements OrderFieldDesigningService {

    @Autowired
    OrderFieldDesigningMapper orderFieldDesigningMapper;

    public Boolean saveOrderFieldDesigning(OrderFieldDesigning orderFieldDesigning){
        int result=orderFieldDesigningMapper.insert(orderFieldDesigning);
        return result>0?true:false;
    }

    @Override
    public List<OrderFieldDesigning> findOrderFieldDesigning(String taskId) {
        OrderFieldDesigningExample orderFieldDesigningExample = new OrderFieldDesigningExample();
        OrderFieldDesigningExample.Criteria criteria = orderFieldDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        return orderFieldDesigningMapper.selectByExample(orderFieldDesigningExample);
    }
}