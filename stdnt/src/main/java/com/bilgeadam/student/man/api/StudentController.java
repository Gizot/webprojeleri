package com.bilgeadam.student.man.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.student.man.dto.StudentDTO;
import com.bilgeadam.student.man.entity.Student;
import com.bilgeadam.student.man.exception.StudentNotFoundException;
import com.bilgeadam.student.man.service.IStudentService;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	@Autowired
	private IStudentService service;
	@GetMapping
	public List<Student> get(){
		return service.list();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Student get(@PathVariable int id) throws StudentNotFoundException{
		
		return service.getStudentById(id);
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> create(@RequestBody @Valid final StudentDTO dto) {
		
		Student student = Student.builder()
				.email(dto.getEmail())
				.grade(dto.getGrade())
				.name(dto.getName())
				.surname(dto.getSurname())
				.build();
		
		service.add(student);
		
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody final StudentDTO dto) 
			throws StudentNotFoundException {
		
		Student existingStudent = service.getStudentById(id);
		
		existingStudent = Student.builder()
				.id(id)
				.email(dto.getEmail())
				.grade(dto.getGrade())
				.name(dto.getName())
				.surname(dto.getSurname())
				.build();
		
		service.update(existingStudent);
		
		return new ResponseEntity<Student>(existingStudent, HttpStatus.OK);
	}
	 
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable Integer id) 
			throws StudentNotFoundException {
		
		Student existingStudent = service.getStudentById(id);
		
		service.delete(existingStudent);
				
		//service.delete(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

}
