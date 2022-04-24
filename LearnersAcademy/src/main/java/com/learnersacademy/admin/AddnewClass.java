package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.LearnersClassDao;
import com.learnersacademy.admin.dao.LearnersClassDaoImpl;
import com.learnersacademy.admin.dto.LearnersClass;


public class AddnewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classname = request.getParameter("classno");
		
		LearnersClass learnersclass = new LearnersClass(classname);
		LearnersClassDao dao= new LearnersClassDaoImpl();
		boolean isClassCreated = dao.addnewClass(learnersclass);
		if(isClassCreated) {
			response.sendRedirect("Success.html");;
		}
		else {
			response.sendRedirect("Failed.html");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
