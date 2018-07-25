package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigningExample;
import com.hywa.bigdata.storage.entity.RuHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.RuHomepageHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.HomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.mapper.RuHomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.service.RuHomepageHandleDesigningService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuHomepageHandleDesigningServiceImpl implements RuHomepageHandleDesigningService {

	@Autowired
	HomepageHandleDesigningMapper homepageHandleDesigningMapper;

	@Autowired
	RuHomepageHandleDesigningMapper ruHomepageHandleDesigningMapper;

	@Override
	public List<RuHomepageHandleDesigning> findByTaskIdAndIsEnalbe(String taskId) {
		RuHomepageHandleDesigningExample ruhomepageHandleDesigningExample = new RuHomepageHandleDesigningExample();
		RuHomepageHandleDesigningExample.Criteria criteria = ruhomepageHandleDesigningExample.createCriteria();
		criteria.andTaskIdEqualTo(taskId);
		criteria.andIsEnableEqualTo(1);
		ruhomepageHandleDesigningExample.setOrderByClause("sort");
		return ruHomepageHandleDesigningMapper.selectByExample(ruhomepageHandleDesigningExample);
	}

	@Override
	public Boolean updateRuHomepageHandleDesigning(List<String> oldTaskId, List<String> taskId) {
		if (!ListKit.isEmpty(oldTaskId)) {
			RuHomepageHandleDesigningExample ruHomepageHandleDesigningExample = new RuHomepageHandleDesigningExample();
			ruHomepageHandleDesigningExample.createCriteria().andTaskIdIn(oldTaskId);
			ruHomepageHandleDesigningMapper.deleteByExample(ruHomepageHandleDesigningExample);
		}
		HomepageHandleDesigningExample homepageHandleDesigningExample = new HomepageHandleDesigningExample();
		homepageHandleDesigningExample.setDistinct(true);
		homepageHandleDesigningExample.createCriteria().andTaskIdIn(taskId);
		List<HomepageHandleDesigning> list = homepageHandleDesigningMapper
				.selectByExample(homepageHandleDesigningExample);
		int i = ruHomepageHandleDesigningMapper.insertBatch(list);
		return list.size() == i ? true : false;
	}

}
