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

/**
 * Servlet implementation class UpdatePwdAction
 */
@WebServlet("/admin/updatePwdAction.do")
public class UpdatePwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String rePwd = request.getParameter("rePwd");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		String pwd = admin.getApwd();
		if(oldPwd.equals(admin.getApwd())) {
			admin.setApwd(newPwd);
			boolean b = adminService.checkPwdUpdateSuccess(admin);
			if(b) {
				response.sendRedirect("../view/login.jsp");
			}else {
				request.setAttribute("errorPwdMsg","对不起，密码修改失敗");
			//	request.getSession().setAttribute("errorPwdMsg", "对不起，密码修改失败");
				response.sendRedirect("../view/user/user_modi_pwd.jsp");
			}
		}else {
			request.setAttribute("errorPwdMsg","对不起，旧密码错误");
		//	request.getSession().setAttribute("errorPwdMsg", "对不起，密码有误");
			response.sendRedirect("../view/user/user_modi_pwd.jsp");
		}
		//request.getRequestDispatcher("../view/user/user_modi_pwd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
