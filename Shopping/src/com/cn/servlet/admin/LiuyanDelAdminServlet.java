package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.LiuyanManaAdminService;

@WebServlet("/liuyanDelAdmin.do")
public class LiuyanDelAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LiuyanManaAdminService liuyanManaAdminService;
	@Override
	public void init() throws ServletException {
		liuyanManaAdminService=new LiuyanManaAdminService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer liuyanId=Integer.parseInt(request.getParameter("liuyanId"));
		liuyanManaAdminService.delLiuYan(liuyanId);
		request.getRequestDispatcher("liuyanManaAdmin.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
