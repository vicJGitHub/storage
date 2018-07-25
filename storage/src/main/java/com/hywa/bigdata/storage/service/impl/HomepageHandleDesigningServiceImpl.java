package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigningExample;
import com.hywa.bigdata.storage.mapper.HomepageHandleDesigningMapper;
import com.hywa.bigdata.storage.service.HomepageHandleDesigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HomepageHandleDesigningServiceImpl implements HomepageHandleDesigningService {

    @Autowired
    HomepageHandleDesigningMapper homepageHandleDesigningMapper;

    @Override
    public List<HomepageHandleDesigning> findByTaskId(String taskId){
        HomepageHandleDesigningExample homepageHandleDesigningExample = new HomepageHandleDesigningExample();
        HomepageHandleDesigningExample.Criteria criteria = homepageHandleDesigningExample.createCriteria();
        criteria.andTaskIdEqualTo(taskId);
        homepageHandleDesigningExample.setOrderByClause("sort");
        //criteria.andIsEnableEqualTo(1);
        return homepageHandleDesigningMapper.selectByExample(homepageHandleDesigningExample);
    }

}
