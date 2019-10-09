package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.MyOrderService;
import com.cn.vo.TOrder;
import com.cn.vo.Tuser;

@WebServlet("/myOrder.do")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyOrderService myOrderService;
	public void init() throws ServletException {
		myOrderService=new MyOrderService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tuser user=(Tuser)request.getSession().getAttribute("user");
		List<TOrder> order=myOrderService.getMyOrder(user);
		request.setAttribute("orderList", order);
		request.getRequestDispatcher("/qiantai/order/myOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
