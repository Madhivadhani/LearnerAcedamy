package com.learnersacademy.admin.dto;

public class LearnersClass {
	private String classno;
	private String subjectname;
	private String teachername;
	public LearnersClass(String classno) {
	
		this.classno = classno;
	}


	


	
	
	
	@Override
	public String toString() {
		return "LearnersClass [classno=" + classno + ", subjectname=" + subjectname + ", teachername=" + teachername
				+ "]";
	}


	public String getClassno() {
		return classno;
	}


	public void setClassno(String classno) {
		this.classno = classno;
	}


	public String getSubjectname() {
		return subjectname;
	}


	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}


	public String getTeachername() {
		return teachername;
	}


	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}


	public LearnersClass(String classno, String subjectname, String teachername) {
		this.classno = classno;
		this.subjectname = subjectname;
		this.teachername = teachername;
	}
	
	
}
