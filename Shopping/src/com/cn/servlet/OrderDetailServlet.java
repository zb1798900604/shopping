package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.OrderDetailService;
import com.cn.vo.TOrderitem;

@WebServlet("/orderDetail.do")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDetailService orderDetailService;
	@Override
	public void init() throws ServletException {
		orderDetailService=new OrderDetailService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		List<TOrderitem> list=orderDetailService.getOrder(orderId);
		request.getSession().setAttribute("orderItemList", list);
		
		request.getRequestDispatcher("qiantai/order/orderDetail.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
