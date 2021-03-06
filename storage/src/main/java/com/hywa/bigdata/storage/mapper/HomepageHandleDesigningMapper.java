package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HomepageHandleDesigning;
import com.hywa.bigdata.storage.entity.HomepageHandleDesigningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomepageHandleDesigningMapper {
    int countByExample(HomepageHandleDesigningExample example);

    int deleteByExample(HomepageHandleDesigningExample example);

    int deleteByPrimaryKey(String id);

    int insert(HomepageHandleDesigning record);

    int insertSelective(HomepageHandleDesigning record);

    List<HomepageHandleDesigning> selectByExample(HomepageHandleDesigningExample example);

    HomepageHandleDesigning selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HomepageHandleDesigning record, @Param("example") HomepageHandleDesigningExample example);

    int updateByExample(@Param("record") HomepageHandleDesigning record, @Param("example") HomepageHandleDesigningExample example);

    int updateByPrimaryKeySelective(HomepageHandleDesigning record);

    int updateByPrimaryKey(HomepageHandleDesigning record);

    int insertBatch(List<HomepageHandleDesigning> homepageHandleDesignings);
}