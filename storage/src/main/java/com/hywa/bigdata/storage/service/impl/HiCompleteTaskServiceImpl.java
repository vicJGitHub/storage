package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.HiCompleteTask;
import com.hywa.bigdata.storage.entity.HiCompleteTaskExample;
import com.hywa.bigdata.storage.entity.HiTaskNodeInfo;
import com.hywa.bigdata.storage.entity.HiTaskNodeInfoExample;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.mapper.HiCompleteTaskMapper;
import com.hywa.bigdata.storage.mapper.HiTaskNodeInfoMapper;
import com.hywa.bigdata.storage.service.HiCompleteTaskService;
import com.hywa.bigdata.storage.service.HiTaskNodeInfoService;
import com.hywa.bigdata.storage.service.RuTaskNodeInfoService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class HiCompleteTaskServiceImpl implements HiCompleteTaskService {

	@Autowired
	HiCompleteTaskMapper hiCompleteTaskMapper;

	@Autowired
	HiTaskNodeInfoService hiTaskNodeInfoService;

	@Autowired
	HiTaskNodeInfoMapper hiTaskNodeInfoMapper;

	@Override
	public int insert(HiCompleteTask hiCompleteTask) {
		return hiCompleteTaskMapper.insert(hiCompleteTask);
	}

	@Override
	public int del(String taskKey) {
		HiCompleteTaskExample hiCompleteTaskExample = new HiCompleteTaskExample();
		HiCompleteTaskExample.Criteria criteria = hiCompleteTaskExample.createCriteria();
		criteria.andTaskKeyEqualTo(taskKey);
		return hiCompleteTaskMapper.deleteByExample(hiCompleteTaskExample);
	}

	@Override
	public int findCount(List<String> permission) {
		if (ListKit.isEmpty(hiCompleteTaskMapper.selectByExample(new HiCompleteTaskExample()))) {
			return 0;
		}
		HiTaskNodeInfoExample hiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		hiTaskNodeInfoExample.createCriteria().andMenuPositionIn(permission);
		List<HiTaskNodeInfo> byMenuPositionAll = hiTaskNodeInfoMapper.selectByExample(hiTaskNodeInfoExample);
		List<String> taskIds = new ArrayList<>();
		byMenuPositionAll.forEach(hiTaskNodeInfo -> taskIds.add(hiTaskNodeInfo.getId()));
		HiCompleteTaskExample hiCompleteTaskExample = new HiCompleteTaskExample();
		HiCompleteTaskExample.Criteria criteria = hiCompleteTaskExample.createCriteria();
		criteria.andTaskIdIn(taskIds);
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		criteria.andCreateTimeBetween(todayStart.getTime(), todayEnd.getTime());
		return hiCompleteTaskMapper.countByExample(hiCompleteTaskExample);
	}
}
