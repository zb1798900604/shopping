package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.CatelogEditPreService;
import com.cn.vo.TCateLog;

@WebServlet("/catelogEditPre.do")
public class CatelogEditPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatelogEditPreService catelogEditPreService;
	@Override
	public void init() throws ServletException {
		catelogEditPreService =new CatelogEditPreService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("catelogId"));
		List<TCateLog> list_tc=catelogEditPreService.queryCatelog(id);

		request.setAttribute("catelog", list_tc);
		request.getRequestDispatcher("admin/catelog/catelogEditPre.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
