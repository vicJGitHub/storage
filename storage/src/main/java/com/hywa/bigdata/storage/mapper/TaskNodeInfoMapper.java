package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.TaskNodeInfo;
import com.hywa.bigdata.storage.entity.TaskNodeInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskNodeInfoMapper {
 
    int countByExample(TaskNodeInfoExample example);

    int deleteByExample(TaskNodeInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TaskNodeInfo record);

    int insertSelective(TaskNodeInfo record);

    List<TaskNodeInfo> selectByExample(TaskNodeInfoExample example);

    TaskNodeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TaskNodeInfo record, @Param("example") TaskNodeInfoExample example);

    int updateByExample(@Param("record") TaskNodeInfo record, @Param("example") TaskNodeInfoExample example);

    int updateByPrimaryKeySelective(TaskNodeInfo record);

    int updateByPrimaryKey(TaskNodeInfo record);

    //批量插入
    int insertBatch(List<TaskNodeInfo> taskNodeInfos);
    
    List<String> findCurrentStep(String processId);
    
    List<String> findMenuByAssigne(@Param("assignee")String assignee,@Param("department")String department);
}