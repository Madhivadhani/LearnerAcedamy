package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learnersacademy.admin.dto.LearnersClass;
import com.learnersacademy.admin.util.ConnectionManagerImpl;

public class LearnersClassDaoImpl implements LearnersClassDao{
	private Connection connection;
	public LearnersClassDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}
	@Override
	public boolean addnewClass(LearnersClass learnerclass) {
		boolean isClassAdded = false;
		 String query = "insert into learnersClass values(?,?,?)";
		 PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1, learnerclass.getClassno());
			statement.setString(2, "null");
			statement.setString(3, "null");
			int val = statement.executeUpdate();
			if(val>0) {
				isClassAdded = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isClassAdded;
	}

	@Override
	public boolean assignSubjectClass(String classname, String subjectname) {
		boolean isSubjectAssigned = false;
		String query = "update learnersclass set subject = ? where classno=?";
		PreparedStatement statement ;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, subjectname);
			statement.setString(2, classname);
			int val = statement.executeUpdate();
			if(val>0) {
				isSubjectAssigned = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSubjectAssigned;
	}

	@Override
	public boolean assignTeacherClass(String classname, String teachername) {
		
		boolean isTeacherAssigned = false;
		String query = "update learnersclass set teacher = ? where classno=?";
		PreparedStatement statement ;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, teachername);
			statement.setString(2, classname);
			int val = statement.executeUpdate();
			if(val>0) {
				isTeacherAssigned = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isTeacherAssigned;
	}
	

}
