package org.lanqiao.controller.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class DeleteRoleAction
 */
@WebServlet("/role/deleteRoleAction.do")
public class DeleteRoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String rid = request.getParameter("rid");
		boolean success = new RoleServiceImpl().deleteRole(Integer.parseInt(rid));
		if(success) {
			request.setAttribute("msg", "删除成功");
		}else {
			request.setAttribute("msg", "删除失败");
		}
		request.getRequestDispatcher("/role/roleListAction.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
