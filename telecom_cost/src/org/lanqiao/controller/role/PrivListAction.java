package org.lanqiao.controller.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.PrivDao;
import org.lanqiao.dao.impl.PrivDaoImpl;
import org.lanqiao.entity.Priv;

/**
 * Servlet implementation class PrivListAction
 */
@WebServlet("/role/privListAction.do")
public class PrivListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrivDao privDao = new PrivDaoImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Priv> lp = privDao.getAllPrivs();
		request.getSession().setAttribute("privList", lp);
		request.getRequestDispatcher("/view/role/role_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
