package com.cn.service.admin;

import com.cn.util.MyDB;

public class DelUserService {
	public void delUser(int id) {
		MyDB.executeUpdate("delete from t_user where user_id=?",id);
	}

}
