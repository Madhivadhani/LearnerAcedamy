package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learnersacademy.admin.dto.Teacher;
import com.learnersacademy.admin.util.ConnectionManagerImpl;

public class TeacherDaoImpl implements TeacherDao {
	private Connection connection;
	public TeacherDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}
	@Override
	public boolean addTeacher(Teacher teacher) {
		boolean isTeacherAdded = false;
		 String query = "insert into teacher values(?,?,?)";
		 PreparedStatement statement ;
		 
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,teacher.getTeachername());
			statement.setString(2, teacher.getEmail());
			statement.setString(3,teacher.getCity());
			
			
			int val = statement.executeUpdate();
			if(val>0) {
				isTeacherAdded = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return isTeacherAdded;
	}

	@Override
	public boolean deleteTeacher(String teachername) {
		boolean isTeacherDeleted = false;
		String query = "delete from teacher where name=? ";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, teachername);
			int val = statement.executeUpdate();
			if (val > 0)
				isTeacherDeleted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return isTeacherDeleted;
	}
	@Override
	public boolean UpdateTeacher(String teachername, String email, String city) {
		boolean isTeacherUpdated = false;
		String query = "update teacher set email = ? , city =? where name=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, city);
			statement.setString(3, teachername);
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
