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


public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String subject=request.getParameter("subject");
		
		Subject sub = new Subject(subject);
		SubjectDao subdao = new SubjectDaoImpl();
		boolean isValidSubject = subdao.validateSubject(subject);
		if(isValidSubject) {
		
		Student student = new Student(fname,lname,email,city,subject);
		StudentDao dao = new StudentDaoImpl();
		boolean isAdded = dao.addStudent(student);
		if(isAdded) {
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
