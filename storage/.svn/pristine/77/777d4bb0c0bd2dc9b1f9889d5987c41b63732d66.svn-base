package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.DesignHomePageInfo;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.OrderDesigningInfo;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;
import java.util.Map;

public interface WindowsInfoService {

    AjaxJson designHomePage(DesignHomePageInfo designHomePageInfo, User user);

    List<HomepageHandleDesigning> designHomePageFindByTaskId(String taskId);

    Map<String, Object> designOrderFindByTaskId(String taskId);

    AjaxJson designOrder(OrderDesigningInfo orderDesigningInfo, User user);
}
