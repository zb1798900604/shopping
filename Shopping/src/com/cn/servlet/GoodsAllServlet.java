package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsAllService;
import com.cn.vo.T_Good;
@WebServlet("/goodAll.do")

public class GoodsAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsAllService goodsAllServicel;
	public void init() throws ServletException {
		goodsAllServicel = new GoodsAllService();
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<T_Good> listgood=goodsAllServicel.goodsAll();
		request.setAttribute("goodsYesTejiaList", listgood);
		
		request.getRequestDispatcher("qiantai/goods/goodsAllNoTejia.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
