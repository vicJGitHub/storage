package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.OrderFieldDesigning;
import com.hywa.bigdata.storage.entity.OrderFieldDesigningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFieldDesigningMapper {
    int countByExample(OrderFieldDesigningExample example);

    int deleteByExample(OrderFieldDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderFieldDesigning record);

    int insertSelective(OrderFieldDesigning record);

    List<OrderFieldDesigning> selectByExample(OrderFieldDesigningExample example);

    OrderFieldDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderFieldDesigning record, @Param("example") OrderFieldDesigningExample example);

    int updateByExample(@Param("record") OrderFieldDesigning record, @Param("example") OrderFieldDesigningExample example);

    int updateByPrimaryKeySelective(OrderFieldDesigning record);

    int updateByPrimaryKey(OrderFieldDesigning record);
    
    int insertBatch(List<OrderFieldDesigning> OrderFieldDesignings);
}