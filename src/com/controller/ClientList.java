package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ClientBean;
import com.dao.ClientDao;

/**
 * Servlet implementation class ClientList
 */
public class ClientList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClientBean>listofClients=new ArrayList<ClientBean>();
		ClientDao clientDao=new ClientDao();
		listofClients=new ClientDao().getclientdetail();
		request.setAttribute("listofClients",listofClients);
		request.getRequestDispatcher("project-list.jsp").forward(request, response);

}
}
