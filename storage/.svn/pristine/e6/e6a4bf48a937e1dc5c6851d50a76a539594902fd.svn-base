package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiTaskNodeInfo;
import com.hywa.bigdata.storage.entity.HiTaskNodeInfoExample;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HiTaskNodeInfoMapper {
    int countByExample(HiTaskNodeInfoExample example);

    int deleteByExample(HiTaskNodeInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiTaskNodeInfo record);

    int insertSelective(HiTaskNodeInfo record);

    List<HiTaskNodeInfo> selectByExample(HiTaskNodeInfoExample example);

    HiTaskNodeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiTaskNodeInfo record, @Param("example") HiTaskNodeInfoExample example);

    int updateByExample(@Param("record") HiTaskNodeInfo record, @Param("example") HiTaskNodeInfoExample example);

    int updateByPrimaryKeySelective(HiTaskNodeInfo record);

    int updateByPrimaryKey(HiTaskNodeInfo record);

    //批量插入
    int insertBatch(List<HiTaskNodeInfo> hiTaskNodeInfo);
    
    List<String> findCurrentStep(String processId);
    
    List<HiTaskNodeInfo> findByMenuPositionOne(String menuPosition);
    
    List<HiTaskNodeInfo> findDelAndComplete(@Param("assignee")String assignee,@Param("department")String department);
}