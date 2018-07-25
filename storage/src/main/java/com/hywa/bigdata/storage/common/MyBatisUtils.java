package com.hywa.bigdata.storage.common;

import com.hywa.bigdata.storage.entity.HiOrderdetailExample;
import com.hywa.bigdata.storage.entity.Orderdetail;
import com.hywa.bigdata.storage.entity.OrderdetailExample;
import org.springframework.util.StringUtils;

public class MyBatisUtils {

    public static OrderdetailExample.Criteria conditionQuery(Orderdetail orderdetail, OrderdetailExample.Criteria criteria) {
        if(!StringUtils.isEmpty(orderdetail.getCurrentStep())&&!orderdetail.getCurrentStep().contains("删除")) {
            criteria.andCurrentStepEqualTo(orderdetail.getCurrentStep());
        }
        if(!StringUtils.isEmpty(orderdetail.getCurrentStep())&&orderdetail.getCurrentStep().contains("删除")) {
        	criteria.andStateEqualTo(3);
        }
        if(!StringUtils.isEmpty(orderdetail.getClient())) {
            criteria.andClientLike("%"+orderdetail.getClient()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getAuditType())) {
            criteria.andAuditTypeLike("%"+orderdetail.getAuditType()+"%");
        }
        //增加按订单号查询
        if(!StringUtils.isEmpty(orderdetail.getCode())) {
            criteria.andCodeLike("%"+orderdetail.getCode()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getTrackingNumber())) {
            criteria.andTrackingNumberLike("%"+orderdetail.getTrackingNumber()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getConsignee())) {
            criteria.andConsigneeLike("%"+orderdetail.getConsignee()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getConsigneePhone())) {
            criteria.andConsigneePhoneLike(orderdetail.getConsigneePhone()+"%");
        }
       if(null!=orderdetail.getStatus()) {
            criteria.andStatusEqualTo(orderdetail.getStatus());
        }
        if(!StringUtils.isEmpty(orderdetail.getTitle())) {
            criteria.andTitleLike("%"+orderdetail.getTitle()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getProcessId())&&!"0".equals(orderdetail.getProcessId())) {
            criteria.andProcessIdEqualTo(orderdetail.getProcessId());
        }
        if("0".equals(orderdetail.getProcessId())) {
        	criteria.andStateEqualTo(3);
        }
        return criteria;
    }
    
  public static HiOrderdetailExample.Criteria hiConditionQuery(Orderdetail orderdetail, HiOrderdetailExample.Criteria criteria) {
        if(!StringUtils.isEmpty(orderdetail.getTrackingNumber())) {
            criteria.andTrackingNumberLike("%"+orderdetail.getTrackingNumber()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getCode())) {
            criteria.andCodeLike("%"+orderdetail.getCode()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getTitle())) {
        	criteria.andTitleLike("%"+orderdetail.getTitle()+"%");
        }
        if(!StringUtils.isEmpty(orderdetail.getProcessId())&&!"0".equals(orderdetail.getProcessId())) {
            criteria.andProcessIdEqualTo(orderdetail.getProcessId());
        }
        if("0".equals(orderdetail.getProcessId())) {
        	criteria.andStateEqualTo(3);
        }
        if(null!=orderdetail.getStatus()) {
        	criteria.andStatusEqualTo(orderdetail.getStatus());
        }
        return criteria;
    }

}
