package com.example.bootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootdemo.dto.Student;

public interface   StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	
	List<Student>findByAge(int age);
	
	List<Student> findByAgeGreaterThan(int age);
	
	List<Student> findByAgeLessThan(int age);
	
	List<Student> findByAgeEquals(int age);
	
	List<Student>findByAgeGreaterThanEqual(int age);
	
	List<Student>findByAgeLessThanEqual(int age);
	
	List<Student>findByAgeBetween(int age1,int age2);

}
