package com.learnersacademy.admin.dao;


import java.util.Set;

import com.learnersacademy.admin.dto.Student;

public interface StudentDao {
	public boolean addStudent(Student student);
	public boolean updateStudent(String fname,String email );
	public boolean updateStudentSubject(String newsubject,String oldsubject );
	public boolean deleteStudent(String fname);
	public boolean assignStudentClass(String subject,String classno);
	public boolean assignStudentSubject(String newsubject,String fname);
	public boolean updateTeacherforSubject(String subjectname,String teachername);
	public Set<Student> getAllStudent();
}
