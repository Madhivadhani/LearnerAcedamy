package com.learnersacademy.admin.dao;

import com.learnersacademy.admin.dto.Teacher;

public interface TeacherDao {
  public boolean addTeacher(Teacher teacher);
  public boolean deleteTeacher(String teachername);
  public boolean UpdateTeacher(String teachername,String email,String city);
}
