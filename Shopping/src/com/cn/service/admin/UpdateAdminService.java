package com.cn.service.admin;

import com.cn.util.MyDB;
import com.cn.vo.TAdmin;

public class UpdateAdminService {
	public void updatePWD(TAdmin tadmin) {
		MyDB.executeUpdate("update t_admin set userName=?,userPw=? where userId=?",tadmin.getUserName(),tadmin.getUserPw(),tadmin.getUserId());
	}
	

}
