package com.cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.util.Cart;

@WebServlet("/updateCart.do")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("goodsId")==null?"0":request.getParameter("goodsId"));
		Integer quantity=Integer.parseInt(request.getParameter("count")==null?"0":request.getParameter("count"));
		String type=request.getParameter("type");
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		if(type!=null && type.equals("del")) {
			cart.delCart(id);
			request.getSession().setAttribute("cart", cart);
		}else if(type!=null && type.equals("clear")) {
			cart.clearCart();
			request.getSession().setAttribute("cart", cart);
		}else{
			cart.updateCart(id, quantity);
			request.getSession().setAttribute("cart", cart);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
