package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.UserDao;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	Connection conn;
	PreparedStatement pre;
	ResultSet res;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("txtemail");
		String userPassword=request.getParameter("txtpassword");
		AdminBean adminBean=new AdminDao().Login(userEmail, userPassword);
		if(adminBean!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("adminBean",adminBean);
			response.sendRedirect("project-list.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
