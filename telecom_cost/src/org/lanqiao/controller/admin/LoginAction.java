package org.lanqiao.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Admin;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminServiceImpl;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/admin/LoginAction.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService adminService = new AdminServiceImpl();   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String acname = request.getParameter("acname");
		String apwd = request.getParameter("apwd");
	//	Hashing.md5().hashString(apwd,Charsets.UTF_8);
		String md = Hashing.md5().newHasher().putString(apwd, Charsets.UTF_8).hash().toString();
		
		Admin admin = adminService.checkUsernameAndPwd(new Admin(acname, md));
	//	String ads = admin.getApwd();
		
		if(admin == null) {
			request.getSession().setAttribute("errorMsg", "用户名或密错误");
			response.sendRedirect("../view/login.jsp");//跳回登录页面
		}else {
			request.getSession().setAttribute("admin", admin);//登录成功，把admin放到session中以供所有页面使用
			response.sendRedirect("../view/index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
