package com.hywa.bigdata.storage.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hywa.bigdata.storage.entity.SysPermission;
import com.hywa.bigdata.storage.entity.SysPermissionExample;
import com.hywa.bigdata.storage.mapper.SysPermissionMapper;
import com.hywa.bigdata.storage.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysPermissionMapper sysPermissionMapper;


    @Override
    public List<SysPermission> findByParentId(String parentId) {
        SysPermissionExample sysPermissionExample = new SysPermissionExample();
        SysPermissionExample.Criteria criteria = sysPermissionExample.createCriteria();
        //criteria.andISMENUEqualTo(true);
        criteria.andCSTATUSEqualTo("2");
        criteria.andPARENT_IDEqualTo(parentId);
        sysPermissionExample.setOrderByClause("guid");
        return sysPermissionMapper.selectByExample(sysPermissionExample);
    }

    @Override
    public String findInfoById(String id) {
        List<String> strings = Arrays.asList(id.split(","));
        List<String>deps=new ArrayList<>();
        strings.forEach(s -> {
            SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(s);
            String dep=sysPermission.getGUID() + ":" + sysPermission.getCNAME();
            deps.add(dep);
        });
        String result=deps.get(0);
        for(int i=1;i<deps.size();i++){
            result=result+","+deps.get(i);
        }
        return result;
    }

    @Override
    public List<SysPermission> findTheBottomMenu() {
        return sysPermissionMapper.findTheBottomMenu();
    }

	@Override
	public String findNameById(String id) {
		if(StringUtils.isEmpty(id))return "";
		return sysPermissionMapper.selectByPrimaryKey(id).getCNAME();
	}
    
    
}
