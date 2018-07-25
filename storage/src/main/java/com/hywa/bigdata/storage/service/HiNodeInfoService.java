package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.entity.HiNodeInfo;

import java.util.List;

public interface HiNodeInfoService {

    int saveHiNodeInfo(String processId,String RealProcess);

    List<HiNodeInfo> findHiNodeInfoByRealProcess(String realProcess);
    
    int delHiNodeInfoByRealProcess(String realProcess);
}
