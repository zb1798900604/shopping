package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.GonggaoManaAdminService;

@WebServlet("/gonggaoDelAdmin.do")
public class GonggaoDelAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GonggaoManaAdminService gonggaoManaAdminService;
	@Override
	public void init() throws ServletException {
		gonggaoManaAdminService=new GonggaoManaAdminService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer gonggaoId=Integer.parseInt(request.getParameter("gonggaoId"));
		gonggaoManaAdminService.delGonggao(gonggaoId);
		request.getRequestDispatcher("gonggaoMana.do").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
