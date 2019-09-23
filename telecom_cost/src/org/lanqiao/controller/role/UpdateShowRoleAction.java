package org.lanqiao.controller.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.entity.Priv;
import org.lanqiao.entity.Role;
import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class UpdateShowRoleAction
 */
@WebServlet("/role/updateShowRoleAction.do")
public class UpdateShowRoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		Role role = new RoleServiceImpl().getRoleById(Integer.parseInt(rid));
		List<Priv> lp = new RoleServiceImpl().getAllPrivs();
		request.setAttribute("privsList", lp);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/view/role/role_modi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
