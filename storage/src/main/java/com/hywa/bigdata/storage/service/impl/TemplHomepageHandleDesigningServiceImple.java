package com.hywa.bigdata.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.TemplHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.TemplHomepageHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.TemplHomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.service.TemplHomepageHandleDesigningService;

@Service
public class TemplHomepageHandleDesigningServiceImple implements  TemplHomepageHandleDesigningService{

	@Autowired
	TemplHomepageHandleDesigningMapper templHomepageHandleDesigningMapper;
	
	@Override
	public List<TemplHomepageHandleDesigning> findAll(String taskId) {
		List<TemplHomepageHandleDesigning> list=templHomepageHandleDesigningMapper.selectByExample(new TemplHomepageHandleDesigningExample());
		list.forEach(t->{
			t.setTaskId(taskId);
			t.setId(IDUtils.getUUID());
		});
		return list;
	}

}
