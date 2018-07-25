package com.hywa.bigdata.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.OrderHandleDesigning;
import com.hywa.bigdata.storage.entity.OrderHandleDesigningExample;
import com.hywa.bigdata.storage.entity.RuOrderHandleDesigning;
import com.hywa.bigdata.storage.entity.RuOrderHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.OrderHandleDesigningMapper;
import com.hywa.bigdata.storage.mapper.RuOrderHandleDesigningMapper;
import com.hywa.bigdata.storage.service.RuOrderHandleDesigningService;

@Service
public class RuOrderHandleDesigningServiceImpl implements RuOrderHandleDesigningService {

	@Autowired
	OrderHandleDesigningMapper orderHandleDesigningMapper;

	@Autowired
	RuOrderHandleDesigningMapper ruOrderHandleDesigningMapper;

	@Override
	public List<RuOrderHandleDesigning> findOrderHandleDesigning(String taskId) {
		RuOrderHandleDesigningExample ruOrderHandleDesigningExample = new RuOrderHandleDesigningExample();
		RuOrderHandleDesigningExample.Criteria criteria = ruOrderHandleDesigningExample.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		criteria.andIsEnableEqualTo(1);
		ruOrderHandleDesigningExample.setOrderByClause("sort");
		return ruOrderHandleDesigningMapper.selectByExample(ruOrderHandleDesigningExample);
	}

	@Override
	public Boolean updateRuOrderHandleDesigning(List<String> oldTaskId, List<String> taskId) {
		if (!ListKit.isEmpty(oldTaskId)) {
			RuOrderHandleDesigningExample ruOrderHandleDesigningExample = new RuOrderHandleDesigningExample();
			ruOrderHandleDesigningExample.createCriteria().andTaskIdIn(oldTaskId);
			ruOrderHandleDesigningMapper.deleteByExample(ruOrderHandleDesigningExample);
		}
		OrderHandleDesigningExample orderHandleDesigningExample = new OrderHandleDesigningExample();
		orderHandleDesigningExample.setDistinct(true);
		orderHandleDesigningExample.createCriteria().andTaskIdIn(taskId);
		List<OrderHandleDesigning> list = orderHandleDesigningMapper.selectByExample(orderHandleDesigningExample);
		int i = ruOrderHandleDesigningMapper.insertBatch(list);
		return list.size() == i ? true : false;
	}
}
