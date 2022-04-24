package com.learnersacademy.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learnersacademy.admin.dto.Admin;
import com.learnersacademy.admin.util.ConnectionManagerImpl;

public class AdminDaoImpl implements AdminDao {
	private Connection connection;
	public AdminDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}
@Override
public boolean validateUser(Admin admin) {
	boolean isUserValid = false;
	
	String query = "select * from admin where username= ? and password = ?";
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, admin.getUsername());
		statement.setString(2, admin.getPassword());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next())
			isUserValid = true;
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
	return isUserValid;
}
}
