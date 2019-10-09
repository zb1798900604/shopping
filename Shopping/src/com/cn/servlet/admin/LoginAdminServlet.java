package com.cn.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.service.admin.LoginAdminService;
import com.cn.vo.TAdmin;


@WebServlet(name = "LoginAdminService",value = "/admin/login.do")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginAdminService loginAdminService;
	public void init() throws ServletException {
		loginAdminService=new LoginAdminService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //��ȡ�û�����
        String username = request.getParameter("userName");
        //��ȡ�û�����
        String password = request.getParameter("userPw");
        //��ȡ�û��������֤��
        String randomCode_req = request.getParameter("randomCode");
        //��ȡ�������ɵ������֤��
        String randomCode = request.getSession().getAttribute("randomCode").toString();

        if(!randomCode_req.equalsIgnoreCase(randomCode)){
            request.getSession().setAttribute("codeError","��֤�벻֤ȷ");
            response.sendRedirect("login.jsp");
        }else {
            List<TAdmin> tAdmins = loginAdminService.getLoginAdmin(username, password);
            if(tAdmins.size()!=0){
               request.getSession().setAttribute("success",tAdmins.get(0));
                response.sendRedirect("index.jsp");
            }else{
                request.getSession().setAttribute("codeError","�ʻ����������");
                response.sendRedirect("login.jsp");
            }
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
