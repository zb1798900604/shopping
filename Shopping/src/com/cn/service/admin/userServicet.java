package com.cn.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.Tuser;

public class userServicet {
	public List<Tuser> queryUser() {
		List<Map<String, Object>> list_user=MyDB.executeQuery("select * from t_user");
		List<Tuser> user=getUser(list_user);
		return user;
	}
	private List<Tuser> getUser(List<Map<String, Object>> map){
		List<Tuser> list_user=new ArrayList<Tuser>();
		for(Map<String, Object> map1:map) {
			Tuser user=new Tuser();
			user.setUser_id((Integer)map1.get("user_id"));
			user.setUser_name(map1.get("user_name").toString());
			user.setUser_pw(map1.get("user_pw").toString());
			user.setUser_type((Integer)map1.get("user_type"));
			user.setUser_realname(map1.get("user_realname").toString());
			user.setUser_address(map1.get("user_address").toString());
			user.setUser_sex(map1.get("user_sex").toString());
			user.setUser_tel(map1.get("user_tel").toString());
			user.setUser_email(map1.get("user_email").toString());
			user.setUser_qq(map1.get("user_qq").toString());
			user.setUser_man(null);
			user.setUser_age(null);
			user.setUser_birthday(null);
			user.setUser_xueli(null);
			user.setUser_del(map1.get("user_del")==null?null:map1.get("user_del").toString());
			user.setUser_one1(null);
			user.setUser_one2(null);
			user.setUser_one3(null);
			user.setUser_one4(null);
			user.setUser_one5(null);
			user.setUser_one6(null);
			user.setUser_one7(null);
			user.setUser_one8(null);
			user.setUser_one9(map1.get("user_one9").toString());
			user.setUser_one10(map1.get("user_one10").toString());
			user.setUser_one11(null);
			user.setUser_one12(null);
			
			list_user.add(user);
		}
		return list_user;
	}

}
