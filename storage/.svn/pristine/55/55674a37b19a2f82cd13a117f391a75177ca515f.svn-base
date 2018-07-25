package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.HiTaskNodeInfoMapper;
import com.hywa.bigdata.storage.mapper.OrderdetailMapper;
import com.hywa.bigdata.storage.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * <p>
 * 任务节点信息 服务实现类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
@Service
public class HiTaskNodeInfoServiceImpl implements HiTaskNodeInfoService {

	@Autowired
	HiTaskNodeInfoMapper hiTaskNodeInfoMapper;

	@Autowired
	SysUserService SysUserService;

	@Autowired
	RuTaskNodeInfoService ruTaskNodeInfoService;

	@Autowired
	HiHomepageHandleDesigningService hiHomepageHandleDesigningService;

	@Autowired
	HiOrderFieldDesigningService hiOrderFieldDesigningService;

	@Autowired
	HiOrderHandleDesigningService hiOrderHandleDesigningService;
	
	@Autowired
	OrderdetailMapper orderdetailMapper;

	// 保存任务节点
	@Override
	public AjaxJson saveHiTaskNodeInfo(HiTaskNodeInfo HiTaskNodeInfo, User user) {
		// id不能为数字,拼接步骤名加id
		HiTaskNodeInfo.setId(HiTaskNodeInfo.getName() + ":" + IDUtils.genId());
		HiTaskNodeInfo.setCreateUser(user.getId());
		HiTaskNodeInfo.setCreateTime(new Date());
		int result = hiTaskNodeInfoMapper.insert(HiTaskNodeInfo);
		Map<String, String> map = new HashMap<>();
		map.put("id", HiTaskNodeInfo.getId());
		return result > 0 ? new AjaxJson(map) : new AjaxJson(1, AjaxJson.MSGFAILURE);
	}

	// 查询任务节点
	@Override
	public List<HiTaskNodeInfo> findHiTaskNodeInfos(String processId, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.setDistinct(true);
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		// 查询作为审核的任务
		criteria.andStepTypeIn(Arrays.asList(0, 1));
		criteria.andProcessIdEqualTo(processId);
		criteria.andNameNotEqualTo("删除审核");
		criteria.andRealProcessEqualTo(realProcess);
		criteria.andIsShowEqualTo(0);
		HiTaskNodeInfoExample.setOrderByClause("sort");
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		return HiTaskNodeInfos;
	}

	@Override
	public List<HiTaskNodeInfo> findHiTaskNodeInfoAll(String processId, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		// 查询作为审核的任务
		criteria.andStepTypeEqualTo(1);
		criteria.andProcessIdEqualTo(processId);
		criteria.andRealProcessEqualTo(realProcess);
		HiTaskNodeInfoExample.setOrderByClause("sort");
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		return HiTaskNodeInfos;
	}

	@Override
	public HiTaskNodeInfo findByMenuPosition(String menuPosition, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		HiTaskNodeInfoExample.setOrderByClause("sort");
		// 查询作为审核的任务
		criteria.andStepTypeEqualTo(0);
		criteria.andMenuPositionEqualTo(menuPosition);
		criteria.andRealProcessEqualTo(realProcess);
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		// 简单的非空判断
		return null != HiTaskNodeInfos && HiTaskNodeInfos.size() > 0 ? HiTaskNodeInfos.get(0) : null;
	}

	@Override
	public AjaxJson saveBatchHiTaskNodeInfo(List<HiTaskNodeInfo> HiTaskNodeInfos, User user) {
		HiTaskNodeInfos.forEach(HiTaskNodeInfo -> {
			if (StringUtils.isEmpty(HiTaskNodeInfo.getId())) {
				HiTaskNodeInfo.setId(IDUtils.getUUID());
				HiTaskNodeInfo.setCreateTime(new Date());
				HiTaskNodeInfo.setCreateUser(user.getId());
				hiTaskNodeInfoMapper.insert(HiTaskNodeInfo);
			} else {
				hiTaskNodeInfoMapper.updateByPrimaryKeySelective(HiTaskNodeInfo);
			}
		});
		return new AjaxJson(0, AjaxJson.MSGSUCCESS);
	}

	@Override
	public HiTaskNodeInfo findById(String id) {
		return hiTaskNodeInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public HiTaskNodeInfo findLikeByName(String name, String orderdetailId) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		// 查询作为审核的任务
		// 当流程走完成时,开启删除审核
		if (StringUtils.isEmpty(name)) {
			name = "删除审核";
		}
		criteria.andNameEqualTo(name);
		criteria.andRealProcessEqualTo(orderdetailId);
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		// 简单的非空判断
		return null != HiTaskNodeInfos && HiTaskNodeInfos.size() > 0 ? HiTaskNodeInfos.get(0) : null;
	}

	@Override
	public List<HiTaskNodeInfo> findAllByProcessId(String processId, String taskId, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.setDistinct(true);
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		criteria.andProcessIdEqualTo(processId);
		if (!StringUtils.isEmpty(realProcess))
			criteria.andRealProcessEqualTo(realProcess);
		HiTaskNodeInfoExample.setOrderByClause("sort");
		if (!StringUtils.isEmpty(taskId))
			criteria.andIdEqualTo(taskId);
		return hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
	}

	@Override
	public HiTaskNodeInfo findByNameAndProcessId(String name, String processId, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andRealProcessEqualTo(realProcess);
		criteria.andProcessIdEqualTo(processId);
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		return ListKit.isEmpty(HiTaskNodeInfos) ? null : HiTaskNodeInfos.get(0);
	}

	@Override
	public List<HiTaskNodeInfo> findByAssigne(String assignee,String menuPosition) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		criteria.andAssigneeLike("%" + assignee + "%");
		if(!StringUtils.isEmpty(menuPosition))criteria.andMenuPositionEqualTo(menuPosition);
		HiTaskNodeInfoExample.Criteria criteria1 = HiTaskNodeInfoExample.createCriteria();
		criteria1.andDepartmentLike("%" + SysUserService.findRefSysDepartmentById(assignee) + "%");
		if(!StringUtils.isEmpty(menuPosition))criteria1.andMenuPositionEqualTo(menuPosition);
		HiTaskNodeInfoExample.or(criteria1);
		return hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
	}

	@Override
	public List<HiTaskNodeInfo> findByMenuPositionAll(String menuPosition, String realProcess) {
		HiTaskNodeInfoExample hiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		hiTaskNodeInfoExample.setDistinct(true);
		HiTaskNodeInfoExample.Criteria criteria = hiTaskNodeInfoExample.createCriteria();
		criteria.andMenuPositionEqualTo(menuPosition);
		if (!StringUtils.isEmpty(realProcess))
			criteria.andRealProcessEqualTo(realProcess);
		return hiTaskNodeInfoMapper.selectByExample(hiTaskNodeInfoExample);
	}

	public List<String> findMenuByAssigne(String assignee, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		criteria.andAssigneeLike("%" + assignee + "%");
		criteria.andSortEqualTo(1);
		criteria.andRealProcessEqualTo(realProcess);
		HiTaskNodeInfoExample.Criteria criteria1 = HiTaskNodeInfoExample.createCriteria();
		criteria1.andDepartmentLike("%" + SysUserService.findRefSysDepartmentById(assignee) + "%");
		criteria1.andSortEqualTo(1);
		criteria1.andRealProcessEqualTo(realProcess);
		HiTaskNodeInfoExample.or(criteria1);
		List<HiTaskNodeInfo> HiTaskNodeInfos =hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		List<String> menus = new ArrayList<>();
		HiTaskNodeInfos.forEach(a -> menus.add(a.getMenuPosition()));
		return menus;
	}

	public String findNameById(String id) {
		return hiTaskNodeInfoMapper.selectByPrimaryKey(id).getName();
	}

	// 作为展示用的历史节点
	@Override
	public int saveHiTaskNodeInfo(String processId, String realProcess) {
		List<RuTaskNodeInfo> nodeInfos = ruTaskNodeInfoService.findAllByProcessId(processId, null);
		List<HiTaskNodeInfo> hiNodeInfos = new ArrayList<>();
		Date date = new Date();
		// 批量保存节点信息
		// 复制到对应的历史节点流程
		nodeInfos.forEach(taskNodeInfo1 -> {
			HiTaskNodeInfo hiTaskNodeInfo = new HiTaskNodeInfo();
			BeanUtils.copyProperties(taskNodeInfo1, hiTaskNodeInfo);
			hiTaskNodeInfo.setId(IDUtils.getUUID());
			hiTaskNodeInfo.setRealProcess(realProcess);
			hiTaskNodeInfo.setCreateTime(date);
			hiHomepageHandleDesigningService.saveHiHomepageHandleDesigning(taskNodeInfo1.getId(),
					hiTaskNodeInfo.getId(), realProcess);
			hiOrderFieldDesigningService.saveHiOrderFieldDesigning(taskNodeInfo1.getId(), hiTaskNodeInfo.getId(),
					realProcess);
			hiOrderHandleDesigningService.saveHiOrderHandleDesigning(taskNodeInfo1.getId(), hiTaskNodeInfo.getId(),
					realProcess);
			hiNodeInfos.add(hiTaskNodeInfo);
		});
		return hiTaskNodeInfoMapper.insertBatch(hiNodeInfos);
	}

	@Override
	public int delByHiTaskNodeInfo(String oldOrderdetailId) {
		HiTaskNodeInfoExample hiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = hiTaskNodeInfoExample.createCriteria();
		criteria.andRealProcessEqualTo(oldOrderdetailId);
		List<HiTaskNodeInfo> hiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(hiTaskNodeInfoExample);
		hiTaskNodeInfos.forEach(hiTaskNodeInfo -> {
			hiHomepageHandleDesigningService.delHiHomepageHandleDesigning(hiTaskNodeInfo.getId());
			hiOrderFieldDesigningService.delHiOrderFieldDesigning(hiTaskNodeInfo.getId());
			hiOrderHandleDesigningService.delHiOrderHandleDesigning(hiTaskNodeInfo.getId());
		});
		return hiTaskNodeInfoMapper.deleteByExample(hiTaskNodeInfoExample);
	}

	@Override
	public List<String> findCurrentStep(String processId) {
		return orderdetailMapper.findCurrentStep(processId);
	}
	
	public List<HiTaskNodeInfo> findByMenuPositionOne(String menuPosition){
		return hiTaskNodeInfoMapper.findByMenuPositionOne(menuPosition);
	}

	public List<HiTaskNodeInfo> findHiTaskNodeInfosAll(String processId, String realProcess) {
		HiTaskNodeInfoExample HiTaskNodeInfoExample = new HiTaskNodeInfoExample();
		HiTaskNodeInfoExample.Criteria criteria = HiTaskNodeInfoExample.createCriteria();
		// 查询作为审核的任务
		criteria.andStepTypeIn(Arrays.asList(0, 1));
		criteria.andProcessIdEqualTo(processId);
		criteria.andRealProcessEqualTo(realProcess);
		HiTaskNodeInfoExample.setOrderByClause("sort");
		List<HiTaskNodeInfo> HiTaskNodeInfos = hiTaskNodeInfoMapper.selectByExample(HiTaskNodeInfoExample);
		return HiTaskNodeInfos;
	}

	@Override
	public List<HiTaskNodeInfo> findDelAndComplete(String assignee, String department) {
		return hiTaskNodeInfoMapper.findDelAndComplete(assignee, department);
	}
	
}
