package com.cn.service.admin;

import com.cn.util.MyDB;

public class CatelogEditService {
	//ÐÞ¸ÄÀà±ð
	public void updateCatelog(int catelogId ,String catelogName,String catelogMiaoshu) {
		MyDB.executeUpdate("update t_catelog set catelog_name=?,catelog_miaoshu=? where catelog_id=?",catelogName,catelogMiaoshu,catelogId);
	}
	

}
