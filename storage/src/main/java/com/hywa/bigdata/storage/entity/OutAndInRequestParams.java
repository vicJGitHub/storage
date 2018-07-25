package com.hywa.bigdata.storage.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class OutAndInRequestParams {

	private String orderNo;//订单号码
	
	private String typeName;//出入库种类，PinkcingOutHouse;ProductionInHouse;PurchaseInHouse;SalesReturnInHouse;SellOutHouse
	
	private String status;//2表示出入库，1表示流程中的删除，4表示删除请求通过审核
	
	private Date outInTime;//出入库时间，格式为 yyyy-MM-dd HH:mm:ss
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOutInTime() {
		return outInTime;
	}

	public void setOutInTime(Date outInTime) {
		this.outInTime = outInTime;
	}

	public OutAndInRequestParams() {
	}

	public OutAndInRequestParams(String orderNo, String typeName, String status, Date outInTime) {
		this.orderNo = orderNo;
		this.typeName = typeName;
		this.status = status;
		this.outInTime = outInTime;
	}

	public Hashtable<String,String> getParam(){
		Hashtable<String, String> tables=new Hashtable<String,String>();
		if(this.orderNo !=null)tables.put("orderNo", getOrderNo());
		if(this.typeName!=null)tables.put("typeName", getTypeName());
		if(this.status!=null)tables.put("status", getStatus());
		if(this.outInTime!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tables.put("outInTime", sdf.format(getOutInTime()));
		}
		return tables;
	}
}
