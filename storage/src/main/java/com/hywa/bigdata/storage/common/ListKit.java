package com.hywa.bigdata.storage.common;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.hywa.bigdata.storage.entity.Orderdetail;

public class ListKit {

    public static boolean isEmpty(List<?> list){
        return !(null!=list&&list.size()>0);
    }
    
    //订单的分页与排序
    public static List<Map<String, Object>> orderSort(Integer page,Integer rows, List<Map<String, Object>> list) {
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> fi1, Map<String, Object> fi2) {
            	String one=((Orderdetail) fi1.get("orderdetailInfo")).getCode();
            	String two =((Orderdetail) fi2.get("orderdetailInfo")).getCode();
            	long onel=Long.parseLong(one);
            	long twol=Long.parseLong(two);
            	long x=onel-twol;
            	return -((int)x);
            }
        });
        Integer start =(page - 1) * rows;
        Integer count = list.size();
        return list.subList(start, count - start > rows ? start + rows : count);
    }
}
