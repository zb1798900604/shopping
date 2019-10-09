package com.cn.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cn.util.MyDB;
import com.cn.vo.Tuser;
public class LoginService {
	public Tuser Login(String username,String password) {
		List<Map<String, Object>> lists = MyDB.executeQuery("select * from t_user where user_name=? and user_pw=?", username,password);
		if(lists.size()!=0)
			return LoginAllxinxi(lists).get(0);
		else
			return null; 
	}
	
	private List<Tuser> LoginAllxinxi(List<Map<String, Object>> map) {
		List<Tuser> user_list=new ArrayList<Tuser>();
		for(Map<String,Object> temp : map) {
            Tuser t_user = new Tuser();
            t_user.setUser_id((Integer)temp.get("user_id"));
            t_user.setUser_name(temp.get("user_name").toString());
            t_user.setUser_pw(temp.get("user_pw").toString());
            t_user.setUser_type((Integer)temp.get("user_type"));
            t_user.setUser_realname(temp.get("user_realname").toString());
            t_user.setUser_address(temp.get("user_address").toString());
            t_user.setUser_sex(temp.get("user_sex").toString());
            t_user.setUser_tel(temp.get("user_tel")==null?null:temp.get("user_tel").toString());
            t_user.setUser_email(temp.get("user_email").toString());
            t_user.setUser_qq(temp.get("user_qq").toString());
            t_user.setUser_man(temp.get("user_man")==null?null:temp.get("user_man").toString());
            t_user.setUser_age(temp.get("user_age")==null?null:temp.get("user_age").toString());
            t_user.setUser_birthday(temp.get("user_birthday")==null?null:temp.get("user_birthday").toString());
            t_user.setUser_xueli(temp.get("user_xueli")==null?null:temp.get("user_xueli").toString());
            t_user.setUser_del(temp.get("user_del")==null?null:temp.get("user_del").toString());
            t_user.setUser_one1(temp.get("user_one1")==null?null:temp.get("user_one1").toString());
            t_user.setUser_one2(temp.get("user_one2")==null?null:temp.get("user_one2").toString());
            t_user.setUser_one3(temp.get("user_one3")==null?null:temp.get("user_one3").toString());
            t_user.setUser_one4(temp.get("user_one4")==null?null:temp.get("user_one4").toString());
            t_user.setUser_one5(temp.get("user_one5")==null?null:temp.get("user_one5").toString());
            t_user.setUser_one6(temp.get("user_one6")==null?0:(Integer)temp.get("user_one6"));
            t_user.setUser_one7(temp.get("user_one7")==null?0:(Integer)temp.get("user_one7"));
            t_user.setUser_one8(temp.get("user_one8")==null?0:(Integer)temp.get("user_one8"));
            t_user.setUser_one9(temp.get("user_one9")==null?null:temp.get("user_one9").toString());
            t_user.setUser_one10(temp.get("user_one10")==null?null:temp.get("user_one10").toString());
            t_user.setUser_one11(temp.get("user_one11")==null?0:(Integer)temp.get("user_one11"));
            t_user.setUser_one12(temp.get("user_one12")==null?0:(Integer)temp.get("user_one12"));
            user_list.add(t_user);
        }
		return user_list;
	}
	
}
