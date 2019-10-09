package com.cn.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.AddLiuYanService;
import com.cn.vo.TLiuYan;
import com.cn.vo.Tuser;

@WebServlet("/liuyanAdd.do")
public class AddLiuYanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddLiuYanService addLiuYanService;
	public void init() throws ServletException {
		addLiuYanService = new AddLiuYanService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    	Tuser user= (Tuser)request.getSession().getAttribute("user");
    	TLiuYan ly=new TLiuYan();
    	ly.setLiuyan_title(request.getParameter("liuyanTitle"));
    	ly.setLiuyan_content(request.getParameter("liuyanContent"));
    	ly.setLiuyan_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    	ly.setLiuyan_user(user.getUser_name());
    	
    	addLiuYanService.addLiuYan(ly);
//    	request.getRequestDispatcher("qiantai/liuyan/liuyanAll.jsp").forward(request, response);
    	 request.getRequestDispatcher("liuyanAll.do").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
