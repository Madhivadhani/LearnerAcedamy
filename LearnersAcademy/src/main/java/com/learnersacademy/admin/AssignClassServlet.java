package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.StudentDao;
import com.learnersacademy.admin.dao.StudentDaoImpl;
import com.learnersacademy.admin.dto.Student;


public class AssignClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String classno = request.getParameter("classno");
		Student student = new Student(fname,classno);
		StudentDao dao = new StudentDaoImpl();
		boolean isAssigned = dao.assignStudentClass(fname, classno);
		if(isAssigned) {
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
