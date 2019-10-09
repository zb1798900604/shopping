package com.cn.service;

import com.cn.util.MyDB;
import com.cn.vo.Tuser;

public class UserEditServict {

	public void userEdit(Tuser user) {
		MyDB.executeUpdate("update t_user set user_name=?,user_pw=?,user_type=?,user_realname=?,user_address=?," +
                " ?,user_man=?,user_age=?,user_birthday=?,user_xueli=?," +
                "user_del=?,user_one1=?,user_one2=?,user_one3=?,user_one4=?,user_one5=?,user_one6=?,user_one7=?," +
                "user_one8=?,user_one9=?,user_one10=?,user_one11=?,user_one12=? where user_id=?",user.getUser_name(),user.getUser_pw(),
                user.getUser_type(),user.getUser_realname(),user.getUser_address(),user.getUser_sex(),user.getUser_tel(),
                user.getUser_email(),user.getUser_qq(),user.getUser_man(),user.getUser_age(),user.getUser_birthday(),
                user.getUser_xueli(),user.getUser_del(),user.getUser_one1(),user.getUser_one2(),user.getUser_one3(),user.getUser_one4(),
                user.getUser_one5(),user.getUser_one6(),user.getUser_one7(),user.getUser_one8(),user.getUser_one9(),
                user.getUser_one10(),user.getUser_one11(),user.getUser_one12(),user.getUser_id());
	}
}
