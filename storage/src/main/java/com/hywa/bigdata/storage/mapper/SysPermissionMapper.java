package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.SysPermission;
import com.hywa.bigdata.storage.entity.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(String GUID);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExampleWithBLOBs(SysPermissionExample example);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(String GUID);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKeyWithBLOBs(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> findTheBottomMenu();
}