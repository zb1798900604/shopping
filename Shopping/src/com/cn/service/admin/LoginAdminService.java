package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.TAdmin;

public class LoginAdminService {
	

	public List<TAdmin> getLoginAdmin(String username,String password){
		List<Map<String, Object>> list = MyDB.executeQuery("select * from t_admin where userName=? and userPw=?", username,password);
		List<TAdmin> admin=	getAll(list);
		return admin;
	}
	private List<TAdmin> getAll(List<Map<String,Object>> map){
		List<TAdmin> listadmin=new ArrayList<TAdmin>();
		for (Map<String, Object> map1 : map) {
			TAdmin admin=new TAdmin();
			admin.setUserId((Integer)map1.get("userId"));
			admin.setUserName(map1.get("userName").toString());
			admin.setUserPw(map1.get("userPw").toString());
			admin.setUserType(map1.get("userType").toString());
			listadmin.add(admin);
		}
		return listadmin;
	}
	
	
	
	
	
}
