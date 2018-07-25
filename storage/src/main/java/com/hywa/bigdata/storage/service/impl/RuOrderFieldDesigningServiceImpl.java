package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.OrderFieldDesigningMapper;
import com.hywa.bigdata.storage.mapper.RuOrderFieldDesigningMapper;
import com.hywa.bigdata.storage.service.RuOrderFieldDesigningService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuOrderFieldDesigningServiceImpl implements RuOrderFieldDesigningService {

	@Autowired
	OrderFieldDesigningMapper orderFieldDesigningMapper;

	@Autowired
	RuOrderFieldDesigningMapper ruOrderFieldDesigningMapper;

	@Override
	public List<RuOrderFieldDesigning> findOrderFieldDesigning(String taskId) {
		RuOrderFieldDesigningExample ruOrderFieldDesigningExample = new RuOrderFieldDesigningExample();
		RuOrderFieldDesigningExample.Criteria criteria = ruOrderFieldDesigningExample.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		return ruOrderFieldDesigningMapper.selectByExample(ruOrderFieldDesigningExample);
	}

	@Override
	public Boolean updateRuOrderFieldDesigning(List<String> oldTaskId, List<String> taskId) {
		if (!ListKit.isEmpty(oldTaskId)) {
			RuOrderFieldDesigningExample ruOrderFieldDesigningExample = new RuOrderFieldDesigningExample();
			ruOrderFieldDesigningExample.createCriteria().andTaskIdIn(oldTaskId);
			ruOrderFieldDesigningMapper.deleteByExample(ruOrderFieldDesigningExample);
		}
		OrderFieldDesigningExample orderFieldDesigningExample = new OrderFieldDesigningExample();
		orderFieldDesigningExample.setDistinct(true);
		orderFieldDesigningExample.createCriteria().andTaskIdIn(taskId);
		List<OrderFieldDesigning> list = orderFieldDesigningMapper.selectByExample(orderFieldDesigningExample);
		int i = ruOrderFieldDesigningMapper.insertBatch(list);
		return list.size() == i ? true : false;
	}
}