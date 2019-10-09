package com.cn.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.OrderManaService;
import com.cn.vo.Tuser;


@WebServlet("/userXinxiAdmin.do")
public class UserXinxiAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderManaService orderManaService;
	@Override
	public void init() throws ServletException {
		orderManaService=new OrderManaService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		Tuser tuserALL = orderManaService.TuserALL(userId);
		request.setAttribute("user", tuserALL);
		request.getRequestDispatcher("admin/order/userXinxi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
