package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.GonggaoManaAdminService;
import com.cn.vo.Tgonggao;

@WebServlet("/gonggaoMana.do")
public class GonggaoManaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GonggaoManaAdminService gonggaoManaAdminService;
	@Override
	public void init() throws ServletException {
		gonggaoManaAdminService=new GonggaoManaAdminService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Tgonggao> listtg=gonggaoManaAdminService.getALLGonggao();
		request.setAttribute("gonggaoList",listtg);
		request.getRequestDispatcher("admin/gonggao/gonggaoMana.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
