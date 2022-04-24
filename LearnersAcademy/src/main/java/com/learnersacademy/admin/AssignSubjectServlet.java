package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.StudentDao;
import com.learnersacademy.admin.dao.StudentDaoImpl;
import com.learnersacademy.admin.dao.SubjectDao;
import com.learnersacademy.admin.dao.SubjectDaoImpl;
import com.learnersacademy.admin.dto.Student;
import com.learnersacademy.admin.dto.Subject;


public class AssignSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectname = request.getParameter("subjectname");
		String studentname = request.getParameter("fname");
		
		Subject sub = new Subject(subjectname);
		SubjectDao dao = new SubjectDaoImpl();
		boolean isValid = dao.validateSubject(subjectname);
		if(isValid) {
			Student std = new Student(subjectname,studentname);
			StudentDao stdao = new StudentDaoImpl();
			boolean updateSub = stdao.assignStudentSubject(subjectname, studentname);
			if(updateSub) {
				response.sendRedirect("Success.html");;
			}
			else {
				response.sendRedirect("Failed.html");
			}
			
			
		}
		else {
			response.sendRedirect("SubjectNotValid.html");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
