package com.cn.service.admin;

import com.cn.util.MyDB;
/*
 * 添加类别服务
 */
public class CatelogAddService {
	public void addCatelogAdd(String catelogName,String catelogMiaoshu) {
		MyDB.executeUpdate("INSERT INTO t_catelog (catelog_name, catelog_miaoshu) VALUES (?, ?)",catelogName,catelogMiaoshu);
	}

}
