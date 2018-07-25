package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.SysDepartment;
import com.hywa.bigdata.storage.entity.SysDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDepartmentMapper {
    int countByExample(SysDepartmentExample example);

    int deleteByExample(SysDepartmentExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysDepartment record);

    int insertSelective(SysDepartment record);

    List<SysDepartment> selectByExampleWithBLOBs(SysDepartmentExample example);

    List<SysDepartment> selectByExample(SysDepartmentExample example);

    SysDepartment selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByExampleWithBLOBs(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByExample(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    int updateByPrimaryKeySelective(SysDepartment record);

    int updateByPrimaryKeyWithBLOBs(SysDepartment record);

    int updateByPrimaryKey(SysDepartment record);
}