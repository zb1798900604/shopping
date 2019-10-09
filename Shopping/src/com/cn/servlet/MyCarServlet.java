package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.IndexService;
import com.cn.vo.TCateLog;
import com.cn.vo.Tgonggao;
@WebServlet("/myCart.do")
public class MyCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexService indexService;
	@Override
	public void init() throws ServletException {
		indexService = new IndexService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TCateLog> tCateLog =indexService.InitLiebei();
		List<Tgonggao> gonggao=indexService.InitGonggao();
        request.setAttribute("feilei",tCateLog);
        request.setAttribute("gonggao",gonggao);
        request.getRequestDispatcher("qiantai/myCart/myCart.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
