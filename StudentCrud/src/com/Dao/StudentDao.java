package com.Dao;

import java.util.List;

import com.Model.Student;

public interface StudentDao {
	
	boolean insertStudent(Student s);
	boolean deleteStudentById(int sid);
	boolean updateStudent(Student s);
	List<Student> getAllStudents();
	Student getStudentById(int sid);
	
	
}
