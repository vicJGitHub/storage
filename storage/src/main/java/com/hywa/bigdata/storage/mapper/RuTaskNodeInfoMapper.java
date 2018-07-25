package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.RuTaskNodeInfo;
import com.hywa.bigdata.storage.entity.RuTaskNodeInfoExample;
import com.hywa.bigdata.storage.entity.TaskNodeInfo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuTaskNodeInfoMapper {
    int countByExample(RuTaskNodeInfoExample example);

    int deleteByExample(RuTaskNodeInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RuTaskNodeInfo record);

    int insertSelective(RuTaskNodeInfo record);

    List<RuTaskNodeInfo> selectByExample(RuTaskNodeInfoExample example);

    RuTaskNodeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RuTaskNodeInfo record, @Param("example") RuTaskNodeInfoExample example);

    int updateByExample(@Param("record") RuTaskNodeInfo record, @Param("example") RuTaskNodeInfoExample example);

    int updateByPrimaryKeySelective(RuTaskNodeInfo record);

    int updateByPrimaryKey(RuTaskNodeInfo record);
    
    List<String> findMenuByAssigne(@Param("assignee")String assignee,@Param("department")String department);
    
    //批量插入
    int insertBatch(List<TaskNodeInfo> taskNodeInfos);
}