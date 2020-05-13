package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ClientBean;
import com.dao.ClientDao;
import com.util.ValidationUtils;

/**
 * Servlet implementation class Client
 */
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName=request.getParameter("txtfirstname");
		String LastName=request.getParameter("txtlastname");
		String DoB=request.getParameter("txtdob");
		String Gender=request.getParameter("txtgender");
		String Departments=request.getParameter("txtdepartment");
		String  Positions=request.getParameter("txtposition");
		int Phones=Integer.parseInt(request.getParameter("txtphone"));
		String Emails=request.getParameter("txtemail");
		int PId=Integer.parseInt(request.getParameter("pname"));
		ClientBean clientBean=new ClientBean();
		clientBean.setcFirstname(FirstName);
		
		clientBean.setcLastname(LastName);
		
		clientBean.setcDob(DoB);
		
		clientBean.setGender(Gender);
		clientBean.setDepartment(Departments);
		clientBean.setPosition(Positions);
		clientBean.setPhone(Phones);
		clientBean.setcEmail(Emails);
		clientBean.setpId(PId);
		System.out.println(FirstName);
		System.out.println(LastName);
		System.out.println(DoB);
		System.out.println(Departments);
		System.out.println(Positions);
		System.out.println(Phones);
		System.out.println(Emails);
		System.out.println(PId);
		
		
		if(new ClientDao().addClient(clientBean))
		{
			System.out.println("Data Inserted sucessfully");
			response.sendRedirect("ClientList");
		}
		else
		{
			System.out.println("Data Not Inserted sucessfully");
			response.sendRedirect("error");
		}
		
		
	}

}
