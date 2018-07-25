package com.hywa.bigdata.storage.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 各种id生成策略
 */
public class IDUtils {

	/**
	 * 图片名生成 fastDFS自动生成图片名
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 
	* @Title: genItemId  生成随机数,用作ID
	*@author vic
	* @Description: TODO
	* @param @return     
	* @return long    
	* @throws
	 */
	public static long genId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static String getFirstCode() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date())+"0001";
	}
	
}
