package com.learnersacademy.admin.dto;

public class Student {
	private String firstname;
	private String lastname;
	private String email;
	private String city;
	private String classno;
	private String teacher;
	private String subject;
	
public Student() {
	
}






	public Student(String firstname, String subject) {
	
	this.firstname = firstname;
	this.email = subject;
}



	public Student(String firstname) {
		this.firstname = firstname;
	}



	public Student(String firstname, String lastname, String email, String city,String subject) {
	
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.city = city;
	this.subject=subject;
}



	public Student(String firstname, String lastname, String email, String city, String classno, String teacher,
			String subject) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.city = city;
		this.classno = classno;
		this.teacher = teacher;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", city=" + city
				+ ", classno=" + classno + ", teacher=" + teacher + ", subject=" + subject + "]";
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getClassno() {
		return classno;
	}

	public void setClassno(String classno) {
		this.classno = classno;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
}
