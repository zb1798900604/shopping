package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.service.UserEditServict;
import com.cn.vo.Tuser;

@WebServlet("/userEdit.do")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserEditServict userEditServict;
	@Override
	public void init() throws ServletException {
		userEditServict =new UserEditServict();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Tuser tuser=new Tuser();
		tuser.setUser_id(Integer.parseInt(request.getParameter("userId")));
		tuser.setUser_name(request.getParameter("userName"));
		tuser.setUser_pw(request.getParameter("userPw"));
		tuser.setUser_realname(request.getParameter("userRealname"));
		tuser.setUser_address(request.getParameter("userAddress"));
		tuser.setUser_sex(request.getParameter("userSex"));
		tuser.setUser_tel(request.getParameter("userTel"));
		tuser.setUser_email(request.getParameter("userEmail"));
		tuser.setUser_qq(request.getParameter("userQq"));
		userEditServict.userEdit(tuser);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		



		doGet(request, response);
	}

}
