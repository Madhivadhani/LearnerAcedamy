package com.learnersacademy.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.AdminDao;
import com.learnersacademy.admin.dao.AdminDaoImpl;
import com.learnersacademy.admin.dto.Admin;


public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		Admin user = new Admin(userName, password);
		AdminDao dao = new AdminDaoImpl();
		boolean isUserValid = dao.validateUser(user);
		if(isUserValid)
			response.sendRedirect("home.html");
		else
			response.sendRedirect("Accessdenied.html");
	}

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
