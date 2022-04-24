package com.learnersacademy.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.admin.dao.SubjectDao;
import com.learnersacademy.admin.dao.SubjectDaoImpl;
import com.learnersacademy.admin.dto.Subject;


public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		Subject sub = new Subject( subject);
		SubjectDao dao = new SubjectDaoImpl();
		boolean isAdded = dao.addSubject(sub);
				if(isAdded) {
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
