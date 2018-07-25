package com.hywa.bigdata.storage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.TemplOrderFieldDesigning;
import com.hywa.bigdata.storage.entity.TemplOrderFieldDesigningExample;
import com.hywa.bigdata.storage.entity.TemplOrderHandleDesigning;
import com.hywa.bigdata.storage.entity.TemplOrderHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.TemplOrderFieldDesigningMapper;
import com.hywa.bigdata.storage.mapper.TemplOrderHandleDesigningMapper;
import com.hywa.bigdata.storage.service.TemplOrderFieldDesigningService;
import com.hywa.bigdata.storage.service.TemplOrderHandleDesigningService;

@Service
public class TemplOrderHandleDesigningServiceImple implements  TemplOrderHandleDesigningService{

	@Autowired
	TemplOrderHandleDesigningMapper templOrderHandleDesigningMapper;
	
	@Override
	public List<TemplOrderHandleDesigning> findAll(String taskId) {
		List<TemplOrderHandleDesigning> list=templOrderHandleDesigningMapper.selectByExample(new TemplOrderHandleDesigningExample());
		list.forEach(t->{
			t.setTaskId(taskId);
			t.setId(IDUtils.getUUID());
		});
		return list;
	}

}
