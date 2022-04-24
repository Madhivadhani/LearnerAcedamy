package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.TeacherDao;
import com.learnersacademy.admin.dao.TeacherDaoImpl;
import com.learnersacademy.admin.dto.Teacher;


public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Teacher teacher = new Teacher(name);
		TeacherDao dao = new TeacherDaoImpl();
		boolean isTeacherDeleted = dao.deleteTeacher(name);
		if(isTeacherDeleted) {
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
