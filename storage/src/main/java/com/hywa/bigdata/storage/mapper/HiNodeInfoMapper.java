package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiNodeInfo;
import com.hywa.bigdata.storage.entity.HiNodeInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HiNodeInfoMapper {
    int countByExample(HiNodeInfoExample example);

    int deleteByExample(HiNodeInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiNodeInfo record);

    int insertSelective(HiNodeInfo record);

    List<HiNodeInfo> selectByExample(HiNodeInfoExample example);

    HiNodeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiNodeInfo record, @Param("example") HiNodeInfoExample example);

    int updateByExample(@Param("record") HiNodeInfo record, @Param("example") HiNodeInfoExample example);

    int updateByPrimaryKeySelective(HiNodeInfo record);

    int updateByPrimaryKey(HiNodeInfo record);

    int insertBatch(List<HiNodeInfo> hiNodeInfos);
}