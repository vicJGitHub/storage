package com.hywa.bigdata.storage.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

// 入库商品详细表
public class HouseiNOutListEntrepotEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 描述：主键id
	 */
	private String guid;
	/**
	 * 描述：商品名称描述：商品名称
	 */
	private String cname;
	/**
	 * 描述：商品编码
	 */
	private String ccode;
	/**
	 * 描述：状态 0：删除 1：未启用 2：启用
	 */
	private String cstatus;
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
	 * 描述：版本号
	 */
	private String cver;
	/**
	 * 描述：商品数量
	 */
	private int productSum;
	/**
	 * 描述：商品类别
	 */
	private String refSysParam;
	/**
	 * 商品单位
	 */
	private String unit;
	/**
	 * 描述：生产日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date cdate;
	/**
	 * 描述：仓库ID
	 */
	private String storeGuid;
	/**
	 * 描述：商品ID
	 */
	private String refZhccProduct;
	/**
	 * 描述：号容量表id
	 */
	private String regionInfoGuid;
	/**
	 * 描述：外键：入库管理的外键 ZHCC_PURCHASE_INPUT_HOUSE
	 */
	private String refZhccPurchaseInputHouse;
	/**
	 * 对应 区域配置表的ID REF_ZHCC_REGION_CONFIG
	 */
	private String regionGuid;
	/**
	 * PRODUCT_UNIT 商品规格
	 */
	private String productUnit;
	/**
	 * PACKAGE_UNIT 包装规格
	 */
	private String packageUnit;
	/**
	 * HOUSE_NUM 记录商品的最小单位
	 */
	private Integer houseNum;
	/**
	 * 保质期单位
	 */
	private String edUnit;
	/**
	 * 保质期
	 */
	private Integer effectiveDate;
	/**
	 * 失效时间
	 */
	private String loseDate;
	/**
	 * 预警期
	 */
	private Integer warningDate;
	/**
	 * 预警期单位
	 */
	private String wdUnit;
	/**
	 * 预警时间
	 */
	private String warningTime;
	/**
	 * 商品每托盘的容量
	 */
	private int palletCapacity;
	/**
	 * 商品入库单的id，针对出库单的商品库存
	 */
	private String refZhccInStoreId;
	/**
	 * 出入库单编号
	 */
	private String outInCode;
	/**
	 * 预警数量
	 */
	private Integer warningNum;
	/**
	 * 联系人外键
	 */
	private String linkManId;
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
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
	public String getCver() {
		return cver;
	}
	public void setCver(String cver) {
		this.cver = cver;
	}
	public int getProductSum() {
		return productSum;
	}
	public void setProductSum(int productSum) {
		this.productSum = productSum;
	}
	public String getRefSysParam() {
		return refSysParam;
	}
	public void setRefSysParam(String refSysParam) {
		this.refSysParam = refSysParam;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getCdate() {
		return cdate/*.getTime()+""*/;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getStoreGuid() {
		return storeGuid;
	}
	public void setStoreGuid(String storeGuid) {
		this.storeGuid = storeGuid;
	}
	public String getRefZhccProduct() {
		return refZhccProduct;
	}
	public void setRefZhccProduct(String refZhccProduct) {
		this.refZhccProduct = refZhccProduct;
	}
	public String getRegionInfoGuid() {
		return regionInfoGuid;
	}
	public void setRegionInfoGuid(String regionInfoGuid) {
		this.regionInfoGuid = regionInfoGuid;
	}
	public String getRefZhccPurchaseInputHouse() {
		return refZhccPurchaseInputHouse;
	}
	public void setRefZhccPurchaseInputHouse(String refZhccPurchaseInputHouse) {
		this.refZhccPurchaseInputHouse = refZhccPurchaseInputHouse;
	}
	public String getRegionGuid() {
		return regionGuid;
	}
	public void setRegionGuid(String regionGuid) {
		this.regionGuid = regionGuid;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getPackageUnit() {
		return packageUnit;
	}
	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}
	public Integer getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(Integer houseNum) {
		this.houseNum = houseNum;
	}
	public String getEdUnit() {
		return edUnit;
	}
	public void setEdUnit(String edUnit) {
		this.edUnit = edUnit;
	}
	public Integer getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Integer effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getLoseDate() {
		return loseDate;
	}
	public void setLoseDate(String loseDate) {
		this.loseDate = loseDate;
	}
	public Integer getWarningDate() {
		return warningDate;
	}
	public void setWarningDate(Integer warningDate) {
		this.warningDate = warningDate;
	}
	public String getWdUnit() {
		return wdUnit;
	}
	public void setWdUnit(String wdUnit) {
		this.wdUnit = wdUnit;
	}
	public String getWarningTime() {
		return warningTime;
	}
	public void setWarningTime(String warningTime) {
		this.warningTime = warningTime;
	}
	public int getPalletCapacity() {
		return palletCapacity;
	}
	public void setPalletCapacity(int palletCapacity) {
		this.palletCapacity = palletCapacity;
	}
	public String getRefZhccInStoreId() {
		return refZhccInStoreId;
	}
	public void setRefZhccInStoreId(String refZhccInStoreId) {
		this.refZhccInStoreId = refZhccInStoreId;
	}
	public String getOutInCode() {
		return outInCode;
	}
	public void setOutInCode(String outInCode) {
		this.outInCode = outInCode;
	}
	public Integer getWarningNum() {
		return warningNum;
	}
	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}
	public String getLinkManId() {
		return linkManId;
	}
	public void setLinkManId(String linkManId) {
		this.linkManId = linkManId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
