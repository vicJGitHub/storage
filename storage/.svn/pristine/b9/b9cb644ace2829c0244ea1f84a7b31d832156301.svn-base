package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HiOrderFieldDesigning;
import com.hywa.bigdata.storage.entity.HiOrderFieldDesigningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HiOrderFieldDesigningMapper {
    int countByExample(HiOrderFieldDesigningExample example);

    int deleteByExample(HiOrderFieldDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiOrderFieldDesigning record);

    int insertSelective(HiOrderFieldDesigning record);

    List<HiOrderFieldDesigning> selectByExample(HiOrderFieldDesigningExample example);

    HiOrderFieldDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiOrderFieldDesigning record, @Param("example") HiOrderFieldDesigningExample example);

    int updateByExample(@Param("record") HiOrderFieldDesigning record, @Param("example") HiOrderFieldDesigningExample example);

    int updateByPrimaryKeySelective(HiOrderFieldDesigning record);

    int updateByPrimaryKey(HiOrderFieldDesigning record);

    int insertBatch(List<HiOrderFieldDesigning> hiOrderFieldDesignings);
}