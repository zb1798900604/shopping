package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.OrderManaService;

@WebServlet("/orderShouli.do")
public class OrderShouliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderManaService orderManaService;
	@Override
	public void init() throws ServletException {
		orderManaService=new OrderManaService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId=Integer.parseInt(request.getParameter("orderId"));
		orderManaService.SouLi(orderId);
		request.getRequestDispatcher("orderMana.do").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
