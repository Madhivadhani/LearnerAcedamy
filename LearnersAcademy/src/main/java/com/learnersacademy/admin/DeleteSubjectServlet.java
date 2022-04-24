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


public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectname = request.getParameter("subjectname");
		Subject sub = new Subject(subjectname);
		SubjectDao dao = new SubjectDaoImpl();
		
		boolean isDeleted = dao.deleteSubject(subjectname);
		if(isDeleted) {
			Student stud = new Student(subjectname);
			StudentDao studao= new StudentDaoImpl();
			boolean isStudentSubjectDeleted = studao.updateStudentSubject("null",subjectname);
			if(isStudentSubjectDeleted) {
				response.sendRedirect("Success.html");;
			}
			else {
				response.sendRedirect("Failed.html");
			}
		}
		else {
			response.sendRedirect("Failed.html");
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
