package com.learnersacademy.admin.dao;

import com.learnersacademy.admin.dto.Subject;

public interface SubjectDao {
	public boolean addSubject(Subject sub);
	public boolean editSubject(String subjectname,String subjectname1);
	public boolean deleteSubject(String subjectname);
	public boolean validateSubject(String subjectname);
}
