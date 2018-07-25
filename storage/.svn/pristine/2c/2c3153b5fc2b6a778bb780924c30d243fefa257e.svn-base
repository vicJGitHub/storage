package com.hywa.bigdata.storage.service;

import java.util.List;
import com.hywa.bigdata.storage.common.AjaxJson;
import com.hywa.bigdata.storage.entity.HiOrderdetail;
import com.hywa.bigdata.storage.entity.Orderdetail;

public interface HiOrderdetailService {
    int save(HiOrderdetail hiOrderdetail);

    int delByOrderdetailAndTaskKey(String orderdetail,String taskKey);

    List<HiOrderdetail> findHiOrderdetail(int page, int rows, AjaxJson ajaxJson, Orderdetail orderdetail,List<String> taskIds);

    int delByOrderdetailId(String orderdetail);
}
