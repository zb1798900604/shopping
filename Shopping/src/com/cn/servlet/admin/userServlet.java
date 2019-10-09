package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.userServicet;
import com.cn.vo.Tuser;

@WebServlet("/userMana.do")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userServicet users;
	public void init() throws ServletException {
		users=new userServicet();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tuser> user=users.queryUser();
		request.setAttribute("userList", user);
//		request.getSession().setAttribute("userList", user);
		request.getRequestDispatcher("admin/user/userMana.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
