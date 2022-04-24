package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.learnersacademy.admin.dto.Student;
import com.learnersacademy.admin.util.ConnectionManagerImpl;

public class StudentDaoImpl implements StudentDao {
	private Connection connection;
	
	public StudentDaoImpl() {
		
		connection = new ConnectionManagerImpl().getConnection();
	}

	@Override
	public boolean addStudent(Student student) {
		boolean isStudentAdded = false;
		 String query = "insert into student values(?,?,?,?,?,?,?)";
		 PreparedStatement statement ;
		 
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,student.getFirstname());
			statement.setString(2, student.getLastname());
			statement.setString(3,student.getEmail());
			statement.setString(4, student.getCity());
			statement.setString(5, "aa");
			statement.setString(6, "aa");
			statement.setString(7, student.getSubject());
			
			int val = statement.executeUpdate();
			if(val>0) {
				isStudentAdded = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return isStudentAdded;
	}

	@Override
	public boolean updateStudent(String fname, String subject) {
		boolean isStudentUpdated = false;
		String query = "update student set subject = ? where fname=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, subject);
			statement.setString(2, fname);
			int val = statement.executeUpdate();
			if (val > 0)
				isStudentUpdated = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isStudentUpdated;
	}

	@Override
	public boolean deleteStudent(String fname) {
		boolean isStudentDeleted = false;
		String query = "delete from student where fname=? ";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, fname);
			int val = statement.executeUpdate();
			if (val > 0)
				isStudentDeleted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return isStudentDeleted;
	}

	@Override
	public boolean assignStudentClass(String subject, String classno) {
		boolean isStudentClassUpdated = false;
		String query = "update student set classno = ? where subject=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, classno);
			statement.setString(2, subject);
			int val = statement.executeUpdate();
			if (val > 0)
				isStudentClassUpdated = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isStudentClassUpdated;
	}

	@Override
	public Set<Student> getAllStudent() {
		Set<Student> allStudent = new HashSet<Student>();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from student");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Student student = new Student();
				student.setFirstname(resultSet.getString(1));
				student.setLastname(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setCity(resultSet.getString(4));
				student.setSubject(resultSet.getString(5));
				student.setClassno(resultSet.getString(6));
				student.setTeacher(resultSet.getString(7));
				allStudent.add(student);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateStudentSubject(String newsubject, String oldsubject) {
		boolean isStudentUpdated = false;
		String query = "update student set subject = ? where subject=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newsubject);
			statement.setString(2, oldsubject);
			int val = statement.executeUpdate();
			if (val > 0)
				isStudentUpdated = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isStudentUpdated;
	}

	@Override
	public boolean assignStudentSubject(String newsubject, String fname) {
		boolean isStudentUpdated = false;
		String query = "update student set subject = ? where fname=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newsubject);
			statement.setString(2, fname);
			int val = statement.executeUpdate();
			if (val > 0)
				isStudentUpdated = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isStudentUpdated;
	}

	@Override
	public boolean updateTeacherforSubject(String subjectname, String teachername) {
		boolean isTeacherUpdated = false;
		String query = "update student set teacher = ? where subject=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, teachername);
			statement.setString(2, subjectname);
			int val = statement.executeUpdate();
			if (val > 0)
				isTeacherUpdated = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isTeacherUpdated;
	}

	
	
}
