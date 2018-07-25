package com.hywa.bigdata.storage.service;

import java.util.List;

import com.hywa.bigdata.storage.entity.HiCompleteTask;

public interface HiCompleteTaskService {

    int insert(HiCompleteTask hiCompleteTask);

    int del(String taskKey);

    int findCount(List<String> permission);
}
