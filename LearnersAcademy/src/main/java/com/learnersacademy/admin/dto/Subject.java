package com.learnersacademy.admin.dto;

public class Subject {
	private String subjectname;
	private String classno;
	private String teachername;
	private String subjectnameold;
	
	public Subject(String subjectname, String classno, String teachername) {
		
		this.subjectname = subjectname;
		this.classno = classno;
		this.teachername = teachername;
		
	}
	
	public Subject(String subjectname) {
	
		this.subjectname = subjectname;
	}
	


	@Override
	public String toString() {
		return "Subject [subjectname=" + subjectname + ", classno=" + classno + ", teachername=" + teachername + "]";
	}
	public Subject(String subjectname, String oldsubjectname) {
		super();
		this.subjectname = subjectname;
		this.subjectnameold = oldsubjectname;
	}

	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
	
}
