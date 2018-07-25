package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.RollBackOrderInfo;
import com.hywa.bigdata.storage.entity.RollBackOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RollBackOrderInfoMapper {
    int countByExample(RollBackOrderInfoExample example);

    int deleteByExample(RollBackOrderInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RollBackOrderInfo record);

    int insertSelective(RollBackOrderInfo record);

    List<RollBackOrderInfo> selectByExample(RollBackOrderInfoExample example);

    RollBackOrderInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RollBackOrderInfo record, @Param("example") RollBackOrderInfoExample example);

    int updateByExample(@Param("record") RollBackOrderInfo record, @Param("example") RollBackOrderInfoExample example);

    int updateByPrimaryKeySelective(RollBackOrderInfo record);

    int updateByPrimaryKey(RollBackOrderInfo record);
    
    int completeRollBackOderdetail(@Param("one")String one,@Param("two")String two);
}