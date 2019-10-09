package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.CatelogEditService;

@WebServlet("/catelogEdit.do")
public class CatelogEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatelogEditService  catelogEditService ;
	@Override
	public void init() throws ServletException {
		catelogEditService =new CatelogEditService(); 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer id=Integer.parseInt(request.getParameter("catelogId"));
		String catelogName=request.getParameter("catelogName");
		String catelogMiaoshu=request.getParameter("catelogMiaoshu");
		catelogEditService.updateCatelog(id, catelogName, catelogMiaoshu);
		
		request.getRequestDispatcher("catelogMana.do").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
