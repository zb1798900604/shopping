package com.cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cn.service.LoginService;
import com.cn.vo.Tuser;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	public void init() throws ServletException {
		loginService=new LoginService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("userPw");
		Tuser user = loginService.Login(username,password);
		if(user!=null){
			request.getSession().setAttribute("user",user);
			request.getRequestDispatcher("index.do").forward(request,response);
		}else{
			request.getRequestDispatcher("index.do").forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
