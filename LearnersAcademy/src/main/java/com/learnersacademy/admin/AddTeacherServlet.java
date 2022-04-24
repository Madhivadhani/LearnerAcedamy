package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.TeacherDao;
import com.learnersacademy.admin.dao.TeacherDaoImpl;
import com.learnersacademy.admin.dto.Teacher;


public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		Teacher teacher= new Teacher(name,email,city);
		TeacherDao dao= new TeacherDaoImpl();
		boolean isTeacherAdded = dao.addTeacher(teacher);
		
		if(isTeacherAdded) {
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
