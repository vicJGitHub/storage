package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.OrderHandleDesigning;
import com.hywa.bigdata.storage.entity.OrderHandleDesigningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderHandleDesigningMapper {
    int countByExample(OrderHandleDesigningExample example);

    int deleteByExample(OrderHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderHandleDesigning record);

    int insertSelective(OrderHandleDesigning record);

    List<OrderHandleDesigning> selectByExample(OrderHandleDesigningExample example);

    OrderHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderHandleDesigning record, @Param("example") OrderHandleDesigningExample example);

    int updateByExample(@Param("record") OrderHandleDesigning record, @Param("example") OrderHandleDesigningExample example);

    int updateByPrimaryKeySelective(OrderHandleDesigning record);

    int updateByPrimaryKey(OrderHandleDesigning record);

    int insertBatch(List<OrderHandleDesigning> orderHandleDesignings);
}