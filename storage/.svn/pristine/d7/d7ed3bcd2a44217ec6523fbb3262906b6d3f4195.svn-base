package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HiOrderHandleDesigning;
import com.hywa.bigdata.storage.entity.HiOrderHandleDesigningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HiOrderHandleDesigningMapper {
    int countByExample(HiOrderHandleDesigningExample example);

    int deleteByExample(HiOrderHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiOrderHandleDesigning record);

    int insertSelective(HiOrderHandleDesigning record);

    List<HiOrderHandleDesigning> selectByExample(HiOrderHandleDesigningExample example);

    HiOrderHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiOrderHandleDesigning record, @Param("example") HiOrderHandleDesigningExample example);

    int updateByExample(@Param("record") HiOrderHandleDesigning record, @Param("example") HiOrderHandleDesigningExample example);

    int updateByPrimaryKeySelective(HiOrderHandleDesigning record);

    int updateByPrimaryKey(HiOrderHandleDesigning record);

    int insertBatch(List<HiOrderHandleDesigning> hiOrderHandleDesignings);
}