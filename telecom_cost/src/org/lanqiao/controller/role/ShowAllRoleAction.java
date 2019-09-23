package org.lanqiao.controller.role;

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
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ShowAllRoleAction
 */
@WebServlet("/role/ShowAllRoleAction.do")
public class ShowAllRoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> lr = new ArrayList<>();
		lr = roleService.selectAllRole();
		request.setAttribute("roleList", lr);
		request.getRequestDispatcher("/view/admin/admin_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
