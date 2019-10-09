package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.service.IndexService;
import com.cn.vo.TCateLog;
import com.cn.vo.T_Good;
import com.cn.vo.Tgonggao;

@WebServlet("/index.do")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexService indexService;
	public void init() throws ServletException {
		indexService = new IndexService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取新款上市的前5条
		List<T_Good> tgood =indexService.Init();
		request.setAttribute("goodsNoTejiaList", tgood);
//		System.out.println(tgood.size());
		
		//获取销量的前5条
		List<T_Good> goods_xiaolaing=indexService.InitXiaoliang();
		request.setAttribute("goodsList", goods_xiaolaing);
		
		
		HttpSession session=request.getSession();
		
		
		
		
		//获取商品类别
		List<TCateLog> list_tCateLog=indexService.InitLiebei();
//		request.setAttribute("feilei", list_tCateLog);
		session.setAttribute("feilei", list_tCateLog);
		//公告
		List<Tgonggao> list_gg=indexService.InitGonggao();
//		request.setAttribute("gonggao",list_gg);
		session.setAttribute("gonggao",list_gg);
		
		request.getRequestDispatcher("qiantai/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
