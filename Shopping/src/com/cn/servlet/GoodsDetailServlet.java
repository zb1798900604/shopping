package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.GoodsDetailService;
import com.cn.vo.T_Good;
import com.cn.vo.Tping;
@WebServlet("/goodsDetail.do")
public class GoodsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsDetailService goodsDetailService;
	@Override
	public void init() throws ServletException {
		goodsDetailService=new GoodsDetailService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("goodsId"));
		//…Ã∆∑œÍœ∏
		try {
			T_Good goods=goodsDetailService.getGoods(id);
			request.getSession().setAttribute("goods", goods);

			//∆¿º€
			Integer pingid=Integer.parseInt(request.getParameter("goodsId"));
			List<Tping> tping=goodsDetailService.getGoodsPinjia(pingid);
			request.getSession().setAttribute("tping", tping);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		request.getRequestDispatcher("qiantai/goods/goodsDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
