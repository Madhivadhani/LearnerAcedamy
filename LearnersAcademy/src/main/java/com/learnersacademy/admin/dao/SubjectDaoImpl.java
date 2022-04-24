package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learnersacademy.admin.dto.Subject;
import com.learnersacademy.admin.util.ConnectionManagerImpl;

public class SubjectDaoImpl implements SubjectDao {
	private Connection connection;
	public SubjectDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}
	@Override
	public boolean addSubject(Subject sub) {
		boolean isSubjectAdded = false;
		String query = "insert into subject values(?,?,?)";
		 PreparedStatement statement ;
		 try {
			statement = connection.prepareStatement(query);
			statement.setString(1,sub.getSubjectname());
			statement.setString(2, "aa");
			statement.setString(3, "aa");
			int val = statement.executeUpdate();
			if(val>0) {
				isSubjectAdded = true;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSubjectAdded;
	}

	@Override
	public boolean editSubject(String subjectname,String oldSubject) {
		boolean isSubjectEdited = false;
		String query = "update subject set subjectname = ? where subjectname=?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, subjectname);
			statement.setString(2, oldSubject);
			int val = statement.executeUpdate();
			if (val > 0)
				isSubjectEdited = true;
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSubjectEdited;
	}

	@Override
	public boolean deleteSubject(String subjectname) {
		boolean isSubjectDeleted =false;
		String query = "delete from subject where subjectname=? ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, subjectname);
			int val = statement.executeUpdate();
			if (val > 0)
				isSubjectDeleted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSubjectDeleted;
	}
	@Override
	public boolean validateSubject(String subjectname) {
		boolean isUserValid = false;
		String query = "select * from subject where subjectname= ? ";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, subjectname);
		
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next())
				isUserValid = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUserValid;
		
	}
	

}
