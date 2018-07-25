package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;

public interface BaseProcessInfoService {

    Boolean saveBaseProcessInfo(BaseProcessInfo baseProcessInfo);

    Boolean updateBaseProcessInfo(BaseProcessInfo baseProcessInfo);

    List<BaseProcessInfo> findBaseProcessInfo(BaseProcessInfo baseProcessInfo,Integer page,Integer rows);

    BaseProcessInfo findById(String id);

    AjaxJson enableDisable(String processId, User user);
}
