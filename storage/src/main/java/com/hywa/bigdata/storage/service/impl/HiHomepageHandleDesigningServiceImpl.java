package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.*;
import com.hywa.bigdata.storage.mapper.HiHomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.service.HiHomepageHandleDesigningService;
import com.hywa.bigdata.storage.service.WindowsInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HiHomepageHandleDesigningServiceImpl implements HiHomepageHandleDesigningService {

    @Autowired
    HiHomepageHandleDesigningMapper hiHomepageHandleDesigningMapper;

    @Autowired
    WindowsInfoService windowsInfoService;

    @Override
    public List<HiHomepageHandleDesigning> findByTaskId(String taskId, String realProcess){
        HiHomepageHandleDesigningExample HiHomepageHandleDesigningExample = new HiHomepageHandleDesigningExample();
        HiHomepageHandleDesigningExample.Criteria criteria = HiHomepageHandleDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        criteria.andRealProcessEqualTo(realProcess);
        HiHomepageHandleDesigningExample.setOrderByClause("sort");
        //criteria.andIsEnableEqualTo(1);
        return hiHomepageHandleDesigningMapper.selectByExample(HiHomepageHandleDesigningExample);
    }

    @Override
    public List<HiHomepageHandleDesigning> findByTaskIdAndIsEnalbe(String taskId, String realProcess){
    HiHomepageHandleDesigningExample HiHomepageHandleDesigningExample = new HiHomepageHandleDesigningExample();
    HiHomepageHandleDesigningExample.Criteria criteria = HiHomepageHandleDesigningExample.createCriteria();
                    criteria.andTaskIdEqualTo(taskId);
                    criteria.andIsEnableEqualTo(1);
                    criteria.andRealProcessEqualTo(realProcess);
                    HiHomepageHandleDesigningExample.setOrderByClause("sort");
    return hiHomepageHandleDesigningMapper.selectByExample(HiHomepageHandleDesigningExample);
    }

    //历史组件
    @Override
    public int saveHiHomepageHandleDesigning(String taskId,String hiTaskId, String RealProcess) {
        List<HomepageHandleDesigning> homepageHandleDesignings = windowsInfoService.designHomePageFindByTaskId(taskId);
        List<HiHomepageHandleDesigning> hiHomepageHandleDesignings=new ArrayList<>();
        homepageHandleDesignings.forEach(homepageHandleDesigning->{
            HiHomepageHandleDesigning hiHomepageHandleDesigning = new HiHomepageHandleDesigning();
            BeanUtils.copyProperties(homepageHandleDesigning,hiHomepageHandleDesigning);
            hiHomepageHandleDesigning.setId(IDUtils.getUUID());
            hiHomepageHandleDesigning.setRealProcess(RealProcess);
            hiHomepageHandleDesigning.setCreateTime(new Date());
            hiHomepageHandleDesigning.setTaskId(hiTaskId);
            hiHomepageHandleDesignings.add(hiHomepageHandleDesigning);
        });
        return hiHomepageHandleDesigningMapper.insertBatch(hiHomepageHandleDesignings);
    }
    
    //del
    //历史组件
    @Override
    public int delHiHomepageHandleDesigning(String taskId) {
    HiHomepageHandleDesigningExample hiHomepageHandleDesigningExample = new HiHomepageHandleDesigningExample();
    HiHomepageHandleDesigningExample.Criteria criteria = hiHomepageHandleDesigningExample.createCriteria();
                    criteria.andTaskIdEqualTo(taskId);
        return hiHomepageHandleDesigningMapper.deleteByExample(hiHomepageHandleDesigningExample );
    }
}
