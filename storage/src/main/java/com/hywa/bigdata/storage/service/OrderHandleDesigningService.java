package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.entity.OrderHandleDesigning;

import java.util.List;

public interface OrderHandleDesigningService {

    List<OrderHandleDesigning> findOrderHandleDesigning(String taskId);
}
