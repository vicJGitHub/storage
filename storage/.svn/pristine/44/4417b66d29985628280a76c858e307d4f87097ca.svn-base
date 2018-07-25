package com.hywa.bigdata.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.TemplOrderFieldDesigning;
import com.hywa.bigdata.storage.entity.TemplOrderFieldDesigningExample;
import com.hywa.bigdata.storage.mapper.TemplOrderFieldDesigningMapper;
import com.hywa.bigdata.storage.service.TemplOrderFieldDesigningService;

@Service
public class TemplOrderFieldDesigningServiceImple implements  TemplOrderFieldDesigningService{

	@Autowired
	TemplOrderFieldDesigningMapper templOrderFieldDesigningMapper;
	
	@Override
	public List<TemplOrderFieldDesigning> findAll(String taskId) {
		List<TemplOrderFieldDesigning> list=templOrderFieldDesigningMapper.selectByExample(new TemplOrderFieldDesigningExample());
		list.forEach(t->{
			t.setTaskId(taskId);
			t.setId(IDUtils.getUUID());
		});
		return list;
	}

}
