package com.bilgeadam.student.man.service;

import java.util.List;

import com.bilgeadam.student.man.entity.Student;
import com.bilgeadam.student.man.exception.StudentNotFoundException;

public interface IStudentService {
	
	List<Student> list();
	Student getStudentById(Integer id) throws StudentNotFoundException;
	Student add(Student student);
	Student update(Student student);
	Integer delete(Student student);
	
}
