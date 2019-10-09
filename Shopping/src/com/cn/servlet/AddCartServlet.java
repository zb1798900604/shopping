package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.AddCartService;
import com.cn.service.IndexService;
import com.cn.util.Cart;
import com.cn.vo.TCateLog;
import com.cn.vo.TOrderitem;
import com.cn.vo.Tgonggao;


@WebServlet("/addCart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexService indexService;
	private AddCartService addCartService;
	
	@Override
	public void init() throws ServletException {
		indexService = new IndexService();
		addCartService= new AddCartService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("goodsId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		TOrderitem tOrderitem = addCartService.getCart(id, quantity);
		
		Cart ct=(Cart)request.getSession().getAttribute("cart");
		if(ct==null) {
			ct=new Cart();
			ct.addCart(id, tOrderitem);
			request.getSession().setAttribute("cart",ct);
		}else {
			ct.addCart(id, tOrderitem);
		}
		
		
		List<TCateLog> tCateLog =indexService.InitLiebei();
		List<Tgonggao> gonggao=indexService.InitGonggao();
        request.setAttribute("feilei",tCateLog);
        request.setAttribute("gonggao",gonggao);
		
		response.sendRedirect("qiantai/myCart/myCart.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
