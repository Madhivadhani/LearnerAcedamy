package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.LearnersClassDao;
import com.learnersacademy.admin.dao.LearnersClassDaoImpl;
import com.learnersacademy.admin.dao.StudentDao;
import com.learnersacademy.admin.dao.StudentDaoImpl;
import com.learnersacademy.admin.dao.SubjectDao;
import com.learnersacademy.admin.dao.SubjectDaoImpl;
import com.learnersacademy.admin.dto.LearnersClass;
import com.learnersacademy.admin.dto.Student;
import com.learnersacademy.admin.dto.Subject;


public class AssignSubjectTeacherClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classname = request.getParameter("classname");
		String subjectname = request.getParameter("subjectname");
		String teachername = request.getParameter("teachername");
		
		LearnersClass learnersclass = new LearnersClass(classname,subjectname,teachername);
		LearnersClassDao dao= new LearnersClassDaoImpl();
		
		Subject sub = new Subject(subjectname);
		SubjectDao subdao= new SubjectDaoImpl();
		
		Student stud =new Student(subjectname,teachername);
		StudentDao studao = new StudentDaoImpl();
		
		
		
		boolean assignSubject = false;
		boolean assignTeacher =false;
		boolean studentupdated =false;
		boolean isClassUpdated = false;
		boolean isSubjectValid = subdao.validateSubject(subjectname);
		if(isSubjectValid) {
			 assignSubject = dao.assignSubjectClass(classname, subjectname);
			 assignTeacher = dao.assignTeacherClass(classname, teachername);
			 studentupdated = studao.updateTeacherforSubject(subjectname, teachername);
			 isClassUpdated = studao.assignStudentClass(subjectname, classname);
				if(assignSubject==true && assignTeacher==true && studentupdated==true && isClassUpdated==true) {
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
