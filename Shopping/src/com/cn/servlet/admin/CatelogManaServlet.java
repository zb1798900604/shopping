package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.CatelogManaService;
import com.cn.vo.TCateLog;


@WebServlet("/catelogMana.do")
public class CatelogManaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatelogManaService catelogManaService;
	@Override
	public void init() throws ServletException {
		catelogManaService = new CatelogManaService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TCateLog> list_tc=catelogManaService.query();
		request.setAttribute("cateLogList", list_tc);
		request.getRequestDispatcher("admin/catelog/catelogMana.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
