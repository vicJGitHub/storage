package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.entity.OrderHandleDesigning;
import com.hywa.bigdata.storage.entity.OrderHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.OrderHandleDesigningMapper;
import com.hywa.bigdata.storage.service.OrderHandleDesigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHandleDesigningServiceImpl implements OrderHandleDesigningService {

    @Autowired
    OrderHandleDesigningMapper orderHandleDesigningMapper;

    @Override
    public List<OrderHandleDesigning> findOrderHandleDesigning(String taskId) {
        OrderHandleDesigningExample orderHandleDesigningExample = new OrderHandleDesigningExample();
        OrderHandleDesigningExample.Criteria criteria = orderHandleDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        criteria.andIsEnableEqualTo(1);
        orderHandleDesigningExample.setOrderByClause("sort");
        return orderHandleDesigningMapper.selectByExample(orderHandleDesigningExample);
    }
}
