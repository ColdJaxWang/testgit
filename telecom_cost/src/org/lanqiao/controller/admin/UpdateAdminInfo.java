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
 * Servlet implementation class UpdateAdminInfo
 */
@WebServlet("/admin/updateAdminInfo.do")
public class UpdateAdminInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService = new AdminServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int aid = ((Admin)request.getSession().getAttribute("admin")).getId(); 
		//int aid = Integer.parseInt(request.getParameter("aid"));
		String aname = request.getParameter("aname");
		String atel = request.getParameter("atel");
		String aemail = request.getParameter("aemail");
		String acname = request.getParameter("acname");
		Admin ad = (Admin)request.getSession().getAttribute("admin");
		//修改session的值
		ad.setAname(aname);
		ad.setAtel(atel);
		ad.setAemail(aemail);
		request.getSession().setAttribute("admin", ad);
		
		boolean b = adminService.updateAdminInfo(new Admin(aid, acname, aname, atel, aemail));
		if(b) {
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("fail");
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
