package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.CatelogAddService;

/*
 * Ìí¼ÓÀà±ð
 */
@WebServlet("/catelogAdd.do")
public class CatelogAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatelogAddService catelogAddService;
	@Override
	public void init() throws ServletException {
		catelogAddService=new CatelogAddService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String catelogName=request.getParameter("catelogName");
		String catelogMiaoshu=request.getParameter("catelogMiaoshu");
		catelogAddService.addCatelogAdd(catelogName, catelogMiaoshu);
		request.getRequestDispatcher("catelogMana.do").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
