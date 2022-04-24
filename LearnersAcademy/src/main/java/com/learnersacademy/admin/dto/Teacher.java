package com.learnersacademy.admin.dto;

public class Teacher {
	private String teachername;
	private String email;
	private String city;
	public Teacher(String teachername, String email, String city) {
	
		this.teachername = teachername;
		this.email = email;
		this.city = city;
	}
	
	public Teacher(String teachername) {
	
		this.teachername = teachername;
	}

	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Teacher [teachername=" + teachername + ", email=" + email + ", city=" + city + "]";
	}
	
	
}
