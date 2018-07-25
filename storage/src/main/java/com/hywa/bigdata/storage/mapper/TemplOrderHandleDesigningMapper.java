package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.TemplOrderHandleDesigning;
import com.hywa.bigdata.storage.entity.TemplOrderHandleDesigningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplOrderHandleDesigningMapper {
    int countByExample(TemplOrderHandleDesigningExample example);

    int deleteByExample(TemplOrderHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(TemplOrderHandleDesigning record);

    int insertSelective(TemplOrderHandleDesigning record);

    List<TemplOrderHandleDesigning> selectByExample(TemplOrderHandleDesigningExample example);

    TemplOrderHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TemplOrderHandleDesigning record, @Param("example") TemplOrderHandleDesigningExample example);

    int updateByExample(@Param("record") TemplOrderHandleDesigning record, @Param("example") TemplOrderHandleDesigningExample example);

    int updateByPrimaryKeySelective(TemplOrderHandleDesigning record);

    int updateByPrimaryKey(TemplOrderHandleDesigning record);
}