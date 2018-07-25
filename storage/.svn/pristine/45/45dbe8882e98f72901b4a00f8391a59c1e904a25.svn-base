package com.hywa.bigdata.storage.service.impl;

import com.hywa.bigdata.storage.common.IDUtils;
import com.hywa.bigdata.storage.entity.HiNodeInfo;
import com.hywa.bigdata.storage.entity.HiNodeInfoExample;
import com.hywa.bigdata.storage.entity.RuTaskNodeInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.mapper.HiNodeInfoMapper;
import com.hywa.bigdata.storage.service.HiNodeInfoService;
import com.hywa.bigdata.storage.service.RuTaskNodeInfoService;
import com.hywa.bigdata.storage.service.TaskNodeInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HiNodeInfoServiceImpl implements HiNodeInfoService {

    @Autowired
    RuTaskNodeInfoService ruTaskNodeInfoService;

    @Autowired
    HiNodeInfoMapper hiNodeInfoMapper;

    //作为展示用的历史节点
    @Override
    public int saveHiNodeInfo(String processId, String RealProcess) {
        List<RuTaskNodeInfo> nodeInfos = ruTaskNodeInfoService.findTaskNodeInfos(processId);
        List<HiNodeInfo> hiNodeInfos = new ArrayList<>();
        //复制到对应的历史节点流程
        nodeInfos.forEach(taskNodeInfo1 -> {
            HiNodeInfo hiNodeInfo = new HiNodeInfo();
            if(!taskNodeInfo1.getName().contains("删除")) {
            	 BeanUtils.copyProperties(taskNodeInfo1, hiNodeInfo);
                 hiNodeInfo.setId(IDUtils.getUUID());
                 hiNodeInfo.setRealProcess(RealProcess);
                 hiNodeInfo.setOldTaskId(taskNodeInfo1.getId());
                 hiNodeInfo.setCreateTime(new Date());
                 hiNodeInfos.add(hiNodeInfo);
            }
        });
        return hiNodeInfoMapper.insertBatch(hiNodeInfos);
    }

    @Override
    public List<HiNodeInfo> findHiNodeInfoByRealProcess(String realProcess) {
        HiNodeInfoExample hiNodeInfoExample = new HiNodeInfoExample();
        hiNodeInfoExample.setDistinct(true);
        HiNodeInfoExample.Criteria criteria = hiNodeInfoExample.createCriteria();
        criteria.andRealProcessEqualTo(realProcess);
        criteria.andIsShowEqualTo(0);
        hiNodeInfoExample.setOrderByClause("sort");
        return hiNodeInfoMapper.selectByExample(hiNodeInfoExample);
    }
    
    @Override
    public int delHiNodeInfoByRealProcess(String realProcess) {
        HiNodeInfoExample hiNodeInfoExample = new HiNodeInfoExample();
        HiNodeInfoExample.Criteria criteria = hiNodeInfoExample.createCriteria();
        criteria.andRealProcessEqualTo(realProcess);
        return hiNodeInfoMapper.deleteByExample(hiNodeInfoExample);
    }
}
