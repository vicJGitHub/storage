package com.hywa.bigdata.storage.common;

import java.util.Collection;

import com.alibaba.fastjson.JSON;

import lombok.Setter;

/**
 * 请求返回 数据封装
 * by  yfw 
 * */
@Setter
public class AjaxJson{
	public static final Integer SUCCESS = 0;
	public static final Integer FAILURE = 1;
	public static final String  MSGSUCCESS = "操作成功！";
	public static final String  MSGFAILURE = "操作失败！";
	public static final String  MSGLOGINERROR = "请登录......";
	public static final String  MSGLOGINORNULL = "请检测是否登录或者数据是否为空......";
	public static final String  MSGNULL = "参数为空！";
	
	/*
	 * code 0:成功 ,1:失败
	 * **/
	private Integer code = SUCCESS;
	
	/*
	 * 返回提示消息
	 * **/
	private String msg = "success";
	/*
	 * 返回对象数据
	 * **/
	private Object data;
	/*
	 * 
	 * 总条数
	 * 选填
	 * **/
	private  Integer  total =SUCCESS;

	public void setTotal(Integer total) {
		this.total = total;
	}

	public AjaxJson(Object data){
		
		this.data = data;
		
	}
	
	public AjaxJson(Object data,Integer total){
		this.data = data;
		this.total = total;
		
	}
	

	public AjaxJson(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	
	public AjaxJson(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public AjaxJson(){}
	
	@Override
	public String toString() {
		
		if(null ==this.data)this.data = new StringBuilder("当前数据为空！");
		return "AjaxJson [code=" + code + ", msg=" + msg + ", data=" +JSON.toJSONString(data) + ", total=" + total + "]";
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public Integer getTotal() {
		
		//外部赋值的情况
		if(this.total > 0 )
			return this.total;
		
		//TODO 集合数据处理
		if(data instanceof Collection<?>){
			Collection<?> collection = (Collection<?>)data;
			if(null !=collection && !collection.isEmpty()){
				int size = collection.size();
				this.total = size;
			}
		}
		return this.total;
	}
	
}
