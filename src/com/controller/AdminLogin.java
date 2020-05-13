package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("txtname");
		String Email=request.getParameter("txtemail");
		String Password=request.getParameter("txtpassword");
		AdminBean adminBean=new AdminBean();
		
		adminBean.seteEmail(Email);
		adminBean.setePassword(Password);
		
		System.out.println(Email);
		System.out.println(Password);
		
		HttpSession session=request.getSession();
		session.setAttribute("Email",Email);
		session.setAttribute("Name", Name);
		response.sendRedirect("index-2.jsp");
		
	}

}
