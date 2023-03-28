package com.bilgeadam.student.man.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilgeadam.student.man.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
