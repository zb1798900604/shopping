package com.cn.service;

import com.cn.util.MyDB;
import com.cn.vo.TLiuYan;

public class AddLiuYanService {
	public void addLiuYan(TLiuYan ly) {
		MyDB.executeUpdate("insert into t_liuyan (liuyan_title,liuyan_content,liuyan_date,liuyan_user) values(?,?,?,?)",ly.getLiuyan_title(),ly.getLiuyan_content(),
				ly.getLiuyan_date(),ly.getLiuyan_user());
	}
	

}
