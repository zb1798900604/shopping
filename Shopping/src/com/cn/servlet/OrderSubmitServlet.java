package com.cn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.OrderService;
import com.cn.util.Cart;
import com.cn.vo.TOrder;
import com.cn.vo.TOrderitem;
import com.cn.vo.T_Good;
import com.cn.vo.Tuser;

@WebServlet("/orderSubmit.do")
public class OrderSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
	public void init() throws ServletException {
		orderService=new OrderService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Tuser user=(Tuser)request.getSession().getAttribute("user");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		
		TOrder order=new TOrder();
		order.setOrder_bianhao(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		order.setOrder_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrder_zhuangtai("no");
		order.setOrder_jine(cart.getTotalPrice());
		order.setOrder_user_id(user.getUser_id());
		order.setOrder_fukuangfangshi(request.getParameter("odderFukuangfangshi"));
		order.setOrder_songhuodizhi(request.getParameter("odderSonghuodizhi"));
		
		Integer order_id=orderService.query(order).getOrder_id();
		for(Iterator it=cart.getItems().values().iterator();it.hasNext();) {
			TOrderitem iteam=(TOrderitem)it.next();
			iteam.setOrder_id(order_id);
			iteam.setGoods_id(iteam.getGoods().getGoods_id());
			
			orderService.insertOrderIteam(iteam);
			
			T_Good goods=orderService.QueryGood(iteam.getGoods().getGoods_id());
			goods.setGoods_kucun(goods.getGoods_kucun()-iteam.getGoods_quantity());
			
			orderService.UpdateGood(goods);
		}
		cart.clearCart();
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("order", order);
		request.getRequestDispatcher("qiantai/order/orderSubmit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
