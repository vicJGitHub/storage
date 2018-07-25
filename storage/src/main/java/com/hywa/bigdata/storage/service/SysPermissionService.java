package com.hywa.bigdata.storage.service;

import com.hywa.bigdata.storage.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> findByParentId(String parentId);

    String findInfoById(String id);

    List<SysPermission> findTheBottomMenu();
    
    String findNameById(String id);
}
