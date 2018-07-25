package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.OrderFieldDesigning;
import com.hywa.bigdata.storage.entity.RuOrderFieldDesigning;
import com.hywa.bigdata.storage.entity.RuOrderFieldDesigningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuOrderFieldDesigningMapper {
    int countByExample(RuOrderFieldDesigningExample example);

    int deleteByExample(RuOrderFieldDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(RuOrderFieldDesigning record);

    int insertSelective(RuOrderFieldDesigning record);

    List<RuOrderFieldDesigning> selectByExample(RuOrderFieldDesigningExample example);

    RuOrderFieldDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RuOrderFieldDesigning record, @Param("example") RuOrderFieldDesigningExample example);

    int updateByExample(@Param("record") RuOrderFieldDesigning record, @Param("example") RuOrderFieldDesigningExample example);

    int updateByPrimaryKeySelective(RuOrderFieldDesigning record);

    int updateByPrimaryKey(RuOrderFieldDesigning record);
    
    int insertBatch(List<OrderFieldDesigning> OrderFieldDesignings);
}