package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.CatelogDelService;

/*
 * É¾³ý
 */
@WebServlet("/catelogDel.do")
public class CatelogDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatelogDelService catelogDelService;
	@Override
	public void init() throws ServletException {
		catelogDelService=new CatelogDelService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer catelogId =Integer.parseInt(request.getParameter("catelogId"));
		catelogDelService.delCatelog(catelogId);
		
		request.getRequestDispatcher("catelogMana.do").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
