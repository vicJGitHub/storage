package com.hywa.bigdata.storage.mapper;

import com.hywa.bigdata.storage.entity.HiOrderdetail;
import com.hywa.bigdata.storage.entity.HiOrderdetailExample;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HiOrderdetailMapper {
    int countByExample(HiOrderdetailExample example);

    int deleteByExample(HiOrderdetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiOrderdetail record);

    int insertSelective(HiOrderdetail record);

    List<HiOrderdetail> selectByExample(HiOrderdetailExample example);

    HiOrderdetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiOrderdetail record, @Param("example") HiOrderdetailExample example);

    int updateByExample(@Param("record") HiOrderdetail record, @Param("example") HiOrderdetailExample example);

    int updateByPrimaryKeySelective(HiOrderdetail record);

    int updateByPrimaryKey(HiOrderdetail record);
    
}