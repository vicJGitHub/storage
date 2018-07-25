package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.BaseProcessInfo;
import com.hywa.bigdata.storage.entity.BaseProcessInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseProcessInfoMapper {
    int countByExample(BaseProcessInfoExample example);

    int deleteByExample(BaseProcessInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseProcessInfo record);

    int insertSelective(BaseProcessInfo record);

    List<BaseProcessInfo> selectByExample(BaseProcessInfoExample example);

    BaseProcessInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseProcessInfo record, @Param("example") BaseProcessInfoExample example);

    int updateByExample(@Param("record") BaseProcessInfo record, @Param("example") BaseProcessInfoExample example);

    int updateByPrimaryKeySelective(BaseProcessInfo record);

    int updateByPrimaryKey(BaseProcessInfo record);
}