package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.TemplHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.TemplHomepageHandleDesigningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplHomepageHandleDesigningMapper {
    int countByExample(TemplHomepageHandleDesigningExample example);

    int deleteByExample(TemplHomepageHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(TemplHomepageHandleDesigning record);

    int insertSelective(TemplHomepageHandleDesigning record);

    List<TemplHomepageHandleDesigning> selectByExample(TemplHomepageHandleDesigningExample example);

    TemplHomepageHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TemplHomepageHandleDesigning record, @Param("example") TemplHomepageHandleDesigningExample example);

    int updateByExample(@Param("record") TemplHomepageHandleDesigning record, @Param("example") TemplHomepageHandleDesigningExample example);

    int updateByPrimaryKeySelective(TemplHomepageHandleDesigning record);

    int updateByPrimaryKey(TemplHomepageHandleDesigning record);
}