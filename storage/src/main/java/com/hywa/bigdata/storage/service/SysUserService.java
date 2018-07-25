package com.hywa.bigdata.storage.service;


import com.hywa.bigdata.storage.entity.SysUser;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author vic
 * @since 2018-05-30
 */
public interface SysUserService {

    List<SysUser> findByDepartment(String refSysDepartment);

    String findInfoById(String id);
    
    String findRealNameById(String id);
    
    public String findRefSysDepartmentById(String id);
}
