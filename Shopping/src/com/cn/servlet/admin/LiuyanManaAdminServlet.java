package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.LiuyanManaAdminService;
import com.cn.vo.TLiuYan;

@WebServlet("/liuyanManaAdmin.do")
public class LiuyanManaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LiuyanManaAdminService liuyanManaAdminService;
	@Override
	public void init() throws ServletException {
		liuyanManaAdminService=new LiuyanManaAdminService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TLiuYan> ly=liuyanManaAdminService.InitLiuYan();
		request.setAttribute("liuyanList", ly);
		request.getRequestDispatcher("admin/liuyan/liuyanMana.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
