package com.hywa.bigdata.storage.service.impl;


import com.github.pagehelper.PageHelper;
import com.hywa.bigdata.storage.common.ListKit;
import com.hywa.bigdata.storage.entity.SysDepartment;
import com.hywa.bigdata.storage.entity.SysDepartmentExample;
import com.hywa.bigdata.storage.mapper.SysDepartmentMapper;
import com.hywa.bigdata.storage.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<SysDepartment> findAll() {
        SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
        SysDepartmentExample.Criteria criteria = sysDepartmentExample.createCriteria();
        criteria.andCstatusEqualTo("2");
        return sysDepartmentMapper.selectByExample(sysDepartmentExample);
    }

    @Override
    public String findInfoById(String id) {
        List<String> strings = Arrays.asList(id.split(","));
        List<String>deps=new ArrayList<>();
        strings.forEach(s -> {
            SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(s);
            if(null!=sysDepartment) {
            String dep=sysDepartment.getGuid() + ":" + sysDepartment.getCname();
            deps.add(dep);
            }
        });
        if(ListKit.isEmpty(deps))return ""; 
        String result=deps.get(0);
        for(int i=1;i<deps.size();i++){
            result=result+","+deps.get(i);
        }
        return result;
    }
}
