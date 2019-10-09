package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.OrderManaService;
import com.cn.vo.TOrder;


@WebServlet("/orderMana.do")
public class OrderManaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderManaService orderManaService;
	@Override
	public void init() throws ServletException {
		orderManaService=new OrderManaService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TOrder> order = orderManaService.getOrder();
		request.setAttribute("orderList", order);
		request.getRequestDispatcher("admin/order/orderMana.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
