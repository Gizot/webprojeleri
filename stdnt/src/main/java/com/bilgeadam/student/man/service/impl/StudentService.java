package com.bilgeadam.student.man.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilgeadam.student.man.entity.Student;
import com.bilgeadam.student.man.exception.StudentNotFoundException;
import com.bilgeadam.student.man.repository.StudentRepository;
import com.bilgeadam.student.man.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private StudentRepository repo;
	
	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException {
		
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			throw new StudentNotFoundException("aranan öğrenci bulunamadı!");
		}
	}

	@Override
	public Student add(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(student);
	}

	@Override
	public Integer delete(Student student) {
		
		repo.delete(student);
		
		return student.getId();
		
	}

}
