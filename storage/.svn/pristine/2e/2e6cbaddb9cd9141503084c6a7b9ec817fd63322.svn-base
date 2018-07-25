package com.hywa.bigdata.storage.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.hywa.bigdata.storage.common.JsonUtils;
//出入库
public class HouseBigEntrepotEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 描述：主键 这里是订单id
	 */
	private String no;
	/**
	 * 流程对象
	 */
	private Orderdetail head = new Orderdetail();
	
	/**
	 * 出入库商品
	 */
	private List<HouseiNOutListEntrepotEntity> items = new ArrayList<>();
	/**
	 *true 为新增  false为修改
	 */
	private boolean addOrEditflag;

	/**
	 * 描述：创建人
	 */
	private String createUser;
	/**
	 * 描述：创建时间
	 */
	private Date createDate;
	/**
	 * 描述：修改人
	 */
	private String updateUser;
	/**
	 * 描述：修改时间
	 */
	private Date updateDate;
	/**
	 * 编码
	 */
	private String ccode;
	/**
	 * 入库时间
	 */
	private Date inputDate;
	/**
	 * 出库时间
	 */
	private String OutDate;
	/**
	 * 出入库类型 1入库 2出库
	 */
	private Integer type = 1;
	/**
	 * 出入库类型
	 */
	private String outInType;
	/**
	 * 出入库编码
	 */
	private String outInCode;
	

	
	
	public String getNo() {
		return no;
	}




	public void setNo(String no) {
		this.no = no;
	}




	public Orderdetail getHead() {
		return head;
	}




	public void setHead(Orderdetail head) {
		this.head = head;
	}




	public List<HouseiNOutListEntrepotEntity> getItems() {
		return items;
	}




	public void setItems(List<HouseiNOutListEntrepotEntity> items) {
		this.items = items;
	}




	public boolean isAddOrEditflag() {
		return addOrEditflag;
	}




	public void setAddOrEditflag(boolean addOrEditflag) {
		this.addOrEditflag = addOrEditflag;
	}




	public String getCreateUser() {
		return createUser;
	}




	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}




	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public String getUpdateUser() {
		return updateUser;
	}




	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}




	public Date getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	public String getCcode() {
		return ccode;
	}




	public void setCcode(String ccode) {
		this.ccode = ccode;
	}


	public String getInputDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:SS:mm").format(inputDate);
	}




	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}




	public String getOutDate() {
		return OutDate;
	}




	public void setOutDate(String outDate) {
		OutDate = outDate;
	}




	public Integer getType() {
		return type;
	}




	public void setType(Integer type) {
		this.type = type;
	}




	public String getOutInType() {
		return outInType;
	}




	public void setOutInType(String outInType) {
		this.outInType = outInType;
	}




	public String getOutInCode() {
		return outInCode;
	}




	public void setOutInCode(String outInCode) {
		this.outInCode = outInCode;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Hashtable<String,String> getParam(){
		Hashtable<String, String> tables=new Hashtable<String,String>();
		if(this.items !=null)tables.put("items", JsonUtils.objectToJson(getItems()));	
		if(this.outInType!=null)tables.put("outInType", getOutInType());
		if(this.inputDate!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tables.put("outInTime", sdf.format(getInputDate()));
		}
		return tables;
	}
}
