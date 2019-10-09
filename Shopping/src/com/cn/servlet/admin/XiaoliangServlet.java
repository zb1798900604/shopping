package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.XiaoLiangService;
import com.cn.vo.T_Good;
@WebServlet("/xiaoliangamdin.do")
public class XiaoliangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private XiaoLiangService xiaoLiangService;
	@Override
	public void init() throws ServletException {
		xiaoLiangService=new XiaoLiangService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<T_Good> good=xiaoLiangService.InitXiaoliang();
		request.setAttribute("goodsList", good);
		request.getRequestDispatcher("admin/xiaoliang/goodsXiaoliang.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
