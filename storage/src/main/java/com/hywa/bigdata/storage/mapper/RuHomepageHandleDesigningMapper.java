package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.RuHomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.RuHomepageHandleDesigningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuHomepageHandleDesigningMapper {
    int countByExample(RuHomepageHandleDesigningExample example);

    int deleteByExample(RuHomepageHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(RuHomepageHandleDesigning record);

    int insertSelective(RuHomepageHandleDesigning record);

    List<RuHomepageHandleDesigning> selectByExample(RuHomepageHandleDesigningExample example);

    RuHomepageHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RuHomepageHandleDesigning record, @Param("example") RuHomepageHandleDesigningExample example);

    int updateByExample(@Param("record") RuHomepageHandleDesigning record, @Param("example") RuHomepageHandleDesigningExample example);

    int updateByPrimaryKeySelective(RuHomepageHandleDesigning record);

    int updateByPrimaryKey(RuHomepageHandleDesigning record);
    
    int insertBatch(List<HomepageHandleDesigning> homepageHandleDesignings);
}