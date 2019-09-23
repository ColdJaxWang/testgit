package org.lanqiao.controller.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Role;
import org.lanqiao.service.RoleService;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class RoleListAction
 */
@WebServlet("/role/roleListAction.do")
public class RoleListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> lr = roleService.getAllRoles();
		request.getSession().setAttribute("roleList", lr);
		request.getRequestDispatcher("/view/role/role_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
