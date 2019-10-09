package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.GoodsManaNoTejiaService;
import com.cn.vo.T_Good;

@WebServlet("/goodsDetailHou.do")
public class GoodsDetailHouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsManaNoTejiaService goodsManaNoTejiaService;
	@Override
	public void init() throws ServletException {
		goodsManaNoTejiaService=new GoodsManaNoTejiaService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer goodsId=Integer.parseInt(request.getParameter("goodsId"));
		
		List<T_Good> good=goodsManaNoTejiaService.queryGoodId(goodsId);
		
		request.setAttribute("goodList", good);
		request.getRequestDispatcher("admin/goods/goodsDetailHou.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
