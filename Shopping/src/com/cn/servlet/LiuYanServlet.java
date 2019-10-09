package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.LiuYanService;
import com.cn.vo.TLiuYan;

@WebServlet("/liuyanAll.do")
public class LiuYanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LiuYanService liuYanService;
	@Override
	public void init() throws ServletException {
		liuYanService=new LiuYanService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TLiuYan> ly=liuYanService.InitLiuYan();
		request.setAttribute("liuyanList",ly);
		request.getRequestDispatcher("qiantai/liuyan/liuyanAll.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
