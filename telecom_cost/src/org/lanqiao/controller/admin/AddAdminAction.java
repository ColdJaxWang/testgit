package org.lanqiao.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Role;
import org.lanqiao.service.AdminService;
import org.lanqiao.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AddAdminAction
 */
@WebServlet("/admin/AddAdminAction.do")
public class AddAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdminService adminService = new AdminServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String aname = request.getParameter("aname");
		String acname = request.getParameter("acname");
		String apwd = request.getParameter("apwd");
		String atel = request.getParameter("atel");
		String aemail = request.getParameter("aemail");
		String[] roleIds = request.getParameterValues("roleIds");
		Admin admin = new Admin();
		admin.setAname(aname);
		admin.setAcname(acname);
		admin.setApwd(apwd);
		admin.setAtel(atel);
		admin.setAemail(aemail);
		List<Role> lr = new ArrayList<>();
		for(String roleId : roleIds) {
			Role role = new Role();
			role.setId(Integer.parseInt(roleId));
			lr.add(role);
		}
		boolean success = adminService.addAdmin(admin, lr);
		if(success) {
			request.getRequestDispatcher("/admin/ShowAllAdminAction.do").forward(request, response);
		}else {
			request.getRequestDispatcher("/view/admin/admin_add.jsp").forward(request, response);
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
