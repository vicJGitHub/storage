package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.entity.OrderFieldDesigning;

import java.util.List;

public interface OrderFieldDesigningService {

    List<OrderFieldDesigning> findOrderFieldDesigning(String taskId);
}
