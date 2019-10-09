package com.cn.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.UpdateAdminService;
import com.cn.vo.TAdmin;

/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/userPwEdit.do")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateAdminService updateAdminService;
	@Override
		public void init() throws ServletException {
			updateAdminService=new UpdateAdminService();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TAdmin tadmin=(TAdmin)request.getSession().getAttribute("success");
		tadmin.setUserPw(request.getParameter("userPw1"));
		updateAdminService.updatePWD(tadmin);
		response.sendRedirect("admin/login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
