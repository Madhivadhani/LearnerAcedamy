package com.learnersacademy.admin.dto;

public class Admin {

	private String username;
	private String password;
	public Admin(String usnername, String password) {
	
		this.username = usnername;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsnername(String usnername) {
		this.username = usnername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [usnername=" + username + ", password=" + password + "]";
	}
	
	
}
