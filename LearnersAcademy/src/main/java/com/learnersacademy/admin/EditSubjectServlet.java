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


public class EditSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldsubjectname = request.getParameter("oldsubjectname");
		String subjectname = request.getParameter("subjectname");
		
		Subject sub = new Subject(oldsubjectname,subjectname);
		SubjectDao dao = new SubjectDaoImpl();
		boolean isModified= dao.editSubject(subjectname, oldsubjectname);
		if(isModified) {
			Student student = new Student(subjectname,oldsubjectname);
			StudentDao studao = new StudentDaoImpl();
			boolean isUpdated = studao.updateStudentSubject(subjectname, oldsubjectname);
			if(isUpdated) {
			response.sendRedirect("Success.html");;
			}else {
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
