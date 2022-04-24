package com.learnersacademy.admin.dao;

import com.learnersacademy.admin.dto.LearnersClass;

public interface LearnersClassDao {
	public boolean addnewClass(LearnersClass learnerclass);
	public boolean assignSubjectClass(String classname,String subjectname);
	public boolean assignTeacherClass(String classname,String teachername);
	
	
}
