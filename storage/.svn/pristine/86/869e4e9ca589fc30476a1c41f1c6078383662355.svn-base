package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiCompleteTask;
import com.hywa.bigdata.storage.entity.HiCompleteTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HiCompleteTaskMapper {
    int countByExample(HiCompleteTaskExample example);

    int deleteByExample(HiCompleteTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiCompleteTask record);

    int insertSelective(HiCompleteTask record);

    List<HiCompleteTask> selectByExample(HiCompleteTaskExample example);

    HiCompleteTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiCompleteTask record, @Param("example") HiCompleteTaskExample example);

    int updateByExample(@Param("record") HiCompleteTask record, @Param("example") HiCompleteTaskExample example);

    int updateByPrimaryKeySelective(HiCompleteTask record);

    int updateByPrimaryKey(HiCompleteTask record);
}