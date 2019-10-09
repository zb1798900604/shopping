package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.DelUserService;

@WebServlet("/userDel.do")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DelUserService delUserService;
	@Override
	public void init() throws ServletException {
		delUserService=new DelUserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("user_id"));
		delUserService.delUser(id);
//		request.getSession().getAttribute("userList");
		request.getRequestDispatcher("admin/user/userMana.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
