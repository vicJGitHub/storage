package com.hywa.bigdata.storage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.DesignHomePageInfo;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigningExample;
import com.hywa.bigdata.storage.entity.OrderDesigningInfo;
import com.hywa.bigdata.storage.entity.OrderFieldDesigning;
import com.hywa.bigdata.storage.entity.OrderFieldDesigningExample;
import com.hywa.bigdata.storage.entity.OrderHandleDesigning;
import com.hywa.bigdata.storage.entity.OrderHandleDesigningExample;
import com.hywa.bigdata.storage.entity.User;
import com.hywa.bigdata.storage.mapper.HomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.mapper.OrderFieldDesigningMapper;
import com.hywa.bigdata.storage.mapper.OrderHandleDesigningMapper;
import com.hywa.bigdata.storage.service.TemplOrderFieldDesigningService;
import com.hywa.bigdata.storage.service.TemplOrderHandleDesigningService;
import com.hywa.bigdata.storage.service.WindowsInfoService;

@Service
public class WindowsServiceImpl implements WindowsInfoService {

	@Autowired
	HomepageHandleDesigningMapper homepageHandleDesigningMapper;

	@Autowired
	OrderHandleDesigningMapper orderHandleDesigningMapper;

	@Autowired
	OrderFieldDesigningMapper orderFieldDesigningMapper;

	@Autowired
	TemplOrderFieldDesigningService templOrderFieldDesigningService;

	@Autowired
	TemplOrderHandleDesigningService templOrderHandleDesigningService;

	@Override
	@Transactional
	public AjaxJson designHomePage(DesignHomePageInfo designHomePageInfo, User user) {
		Date date = new Date();
		List<HomepageHandleDesigning> homepageHandleDesignings = designHomePageInfo.getData();
		HomepageHandleDesigningExample homepageHandleDesigningExample = new HomepageHandleDesigningExample();
		homepageHandleDesigningExample.createCriteria().andTaskIdEqualTo(homepageHandleDesignings.get(0).getTaskId());
		homepageHandleDesigningMapper.deleteByExample(homepageHandleDesigningExample);
		homepageHandleDesignings.forEach(homepageHandleDesigning -> {
			homepageHandleDesigning.setCreateTime(date);
			homepageHandleDesigning.setCreateUser(user.getId());
		});
		return homepageHandleDesignings.size() == homepageHandleDesigningMapper.insertBatch(homepageHandleDesignings)
				? new AjaxJson(0, AjaxJson.MSGSUCCESS)
				: new AjaxJson(1, AjaxJson.MSGFAILURE);
	}

	@Override
	public List<HomepageHandleDesigning> designHomePageFindByTaskId(String taskId) {
		HomepageHandleDesigningExample homepageHandleDesigningExample = new HomepageHandleDesigningExample();
		HomepageHandleDesigningExample.Criteria criteria = homepageHandleDesigningExample.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		return homepageHandleDesigningMapper.selectByExample(homepageHandleDesigningExample);
	}

	@Override
	public Map<String, Object> designOrderFindByTaskId(String taskId) {
		Map<String, Object> map = new HashMap<>();
		OrderFieldDesigningExample orderFieldDesigningExample = new OrderFieldDesigningExample();
		OrderFieldDesigningExample.Criteria criteria = orderFieldDesigningExample.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		List<OrderFieldDesigning> orderFieldDesignings = orderFieldDesigningMapper
				.selectByExample(orderFieldDesigningExample);
		Object o1 = !ListKit.isEmpty(orderFieldDesignings) ? orderFieldDesignings
				: templOrderFieldDesigningService.findAll(taskId);
		map.put("orderFieldDesignings", o1);
		OrderHandleDesigningExample orderHandleDesigningExample = new OrderHandleDesigningExample();
		OrderHandleDesigningExample.Criteria criteria1 = orderHandleDesigningExample.createCriteria();
		criteria1.andTaskIdEqualTo(taskId);
		List<OrderHandleDesigning> orderHandleDesignings = orderHandleDesigningMapper
				.selectByExample(orderHandleDesigningExample);
		Object o2 = !ListKit.isEmpty(orderHandleDesignings) ? orderHandleDesignings
				: templOrderHandleDesigningService.findAll(taskId);
		map.put("orderHandleDesignings", o2);
		return map;
	}

	@Override
	@Transactional
	public AjaxJson designOrder(OrderDesigningInfo orderDesigningInfo, User user) {
		Date date = new Date();
		List<OrderFieldDesigning> orderFieldDesignings = orderDesigningInfo.getOrderFieldDesignings();
		OrderFieldDesigningExample orderFieldDesigningExample = new OrderFieldDesigningExample();
		orderFieldDesigningExample.createCriteria().andTaskIdEqualTo(orderFieldDesignings.get(0).getTaskId());
		orderFieldDesigningMapper.deleteByExample(orderFieldDesigningExample);
		orderFieldDesignings.forEach(orderFieldDesigning -> {
			orderFieldDesigning.setCreateTime(date);
			orderFieldDesigning.setCreateUser(user.getId());
		});
		int orderFieldDesigningCount = orderFieldDesigningMapper.insertBatch(orderFieldDesignings);

		List<OrderHandleDesigning> orderHandleDesignings = orderDesigningInfo.getOrderHandleDesignings();
		OrderHandleDesigningExample orderHandleDesigningExample = new OrderHandleDesigningExample();
		orderHandleDesigningExample.createCriteria().andTaskIdEqualTo(orderHandleDesignings.get(0).getTaskId());
		orderHandleDesigningMapper.deleteByExample(orderHandleDesigningExample);
		orderHandleDesignings.forEach(orderHandleDesigning -> {
			orderHandleDesigning.setCreateTime(date);
			orderHandleDesigning.setCreateUser(user.getId());
		});
		int orderHandleDesigningCount = orderHandleDesigningMapper.insertBatch(orderHandleDesignings);

		return (orderFieldDesignings.size() + orderHandleDesignings.size()) == (orderFieldDesigningCount
				+ orderHandleDesigningCount) ? new AjaxJson(0, AjaxJson.MSGSUCCESS)
						: new AjaxJson(1, AjaxJson.MSGFAILURE);
	}
}
