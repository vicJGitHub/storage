package com.hywa.bigdata.storage.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderHandleDesigning {
	private String id;
	@NotNull(message = "操作名称不能为空")
	@Size(min = 0, message = "操作名称不能为空")
	private String name;

	private Date createTime;

	private String anotherName;
	@NotNull(message = "节点信息不能为空")
	@Size(min = 0, message = "节点信息不能为空")
	private String taskId;

	private Date updateTime;

	private String createUser;

	private String updateUser;

	private Integer isGeneratePassword;

	private String passwordAnotherName;
	@NotNull(message = "办理类型不能为空")
	@Max(value = 1, message = "办理类型参数有误")
	@Min(value = 0, message = "办理类型参数有误")
	private Integer type;

	private Integer isEnable;

	private Integer sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAnotherName() {
		return anotherName;
	}

	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName == null ? null : anotherName.trim();
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId == null ? null : taskId.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public Integer getIsGeneratePassword() {
		return isGeneratePassword;
	}

	public void setIsGeneratePassword(Integer isGeneratePassword) {
		this.isGeneratePassword = isGeneratePassword;
	}

	public String getPasswordAnotherName() {
		return passwordAnotherName;
	}

	public void setPasswordAnotherName(String passwordAnotherName) {
		this.passwordAnotherName = passwordAnotherName == null ? null : passwordAnotherName.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}