package com.hywa.bigdata.storage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.MyBatisUtils;
import com.hywa.bigdata.storage.entity.HiOrderdetail;
import com.hywa.bigdata.storage.entity.HiOrderdetailExample;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.mapper.HiOrderdetailMapper;
import com.hywa.bigdata.storage.service.HiNodeInfoService;
import com.hywa.bigdata.storage.service.HiOrderdetailService;
import com.hywa.bigdata.storage.service.HiTaskNodeInfoService;
import com.hywa.bigdata.storage.service.SysUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiOrderdetailServiceImpl implements HiOrderdetailService {

	@Autowired
	HiOrderdetailMapper hiOrderdetailMapper;

	@Autowired
	HiTaskNodeInfoService hiTaskNodeInfoService;

	@Autowired
	HiNodeInfoService hiNodeInfoService;

	@Autowired
	SysUserService sysUserService;

	@Override
	public int save(HiOrderdetail hiOrderdetail) {
		return hiOrderdetailMapper.insert(hiOrderdetail);
	}

	@Override
	public int delByOrderdetailAndTaskKey(String orderdetail, String currentStep) {
		HiOrderdetailExample hiOrderdetailExample = new HiOrderdetailExample();
		HiOrderdetailExample.Criteria criteria = hiOrderdetailExample.createCriteria();
		criteria.andOrderdetailIdEqualTo(orderdetail);
		criteria.andCurrentStepEqualTo(currentStep);
		return hiOrderdetailMapper.deleteByExample(hiOrderdetailExample);
	}

	@Override
	public List<HiOrderdetail> findHiOrderdetail(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail,
			List<String> taskIds) {
		PageHelper.startPage(1, page * rows, "code desc");
		HiOrderdetailExample hiOrderdetailExample = new HiOrderdetailExample();
		HiOrderdetailExample.Criteria criteria = hiOrderdetailExample.createCriteria();
		criteria.andStateNotEqualTo(4);
		criteria.andTaskIdIn(taskIds);
		MyBatisUtils.hiConditionQuery(orderdetail, criteria);
		List<HiOrderdetail> list = hiOrderdetailMapper.selectByExample(hiOrderdetailExample);
		PageInfo pageInfo = new PageInfo<>(list);
		ajaxJson.setTotal((int) pageInfo.getTotal() + ajaxJson.getTotal());
		return list;
	}

	@Override
	public int delByOrderdetailId(String orderdetailId) {
		HiOrderdetailExample hiOrderdetailExample = new HiOrderdetailExample();
		HiOrderdetailExample.Criteria criteria = hiOrderdetailExample.createCriteria();
		criteria.andOrderdetailIdEqualTo(orderdetailId);
		List<HiOrderdetail> hiOrderdetails = hiOrderdetailMapper.selectByExample(hiOrderdetailExample);
		int count = 0;
		for (HiOrderdetail hiOrderdetail : hiOrderdetails) {
			hiOrderdetail.setState(4);
			count += hiOrderdetailMapper.updateByPrimaryKeySelective(hiOrderdetail);
		}
		;
		return count;
	}
}
