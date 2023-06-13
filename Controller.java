package com.example.bootdemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Student;
import com.example.bootdemo.repository.StudentRepository;


@RestController
public class Controller {
	
	@Autowired
	StudentRepository sr;

	@PostMapping("/hi")
	public  String m1() {
		return "hello good evening";
	}
	
	
	@GetMapping("/hi")
	public String m2() {
		return ("get request is handled");
	}
	
//	if we write sysout it will print on consol
	
//	@PostMapping("/hi")
//	public String  m3() {  
//		
//		return "post request handled";
//	}
	
	@DeleteMapping("/hii")
  public String m3() {
	  return "delete the requst";
  }
	
	
	
	
	
	@PostMapping("/savedata")
	public String save(@RequestBody Student s) 
	{
		sr.save(s);
		return "data saved sucssfully";
		
	}
	
	
	
	
	
	@GetMapping("/fetchdata")
	public Student fetchStudentByIdStudent(@RequestParam int id) {
		
		Optional<Student> ou=sr.findById(id);
		Student s=ou.get(); 
		return s;
	}
	
	
	@GetMapping("/findstudentbyname")
	public List<Student> fetchStudentByName(@RequestParam String name){
		List<Student> stu=sr.findByName(name);
		return stu;
	}
	
	
	@GetMapping("/findallstudents")
	List<Student> fetchAllStudent(){
		List <Student> student=sr.findAll();
		 return student;
	}

	@GetMapping("/findstudentsbyagegraterthan")
	public List<Student>fetchstudentbygraterthan(@RequestParam int age){
		List<Student> student=sr.findByAgeGreaterThan(age);
		return student;
	}
	@GetMapping("/findstudentbylessthan")
	public List<Student> fetchstudentbylessthan(@RequestParam int age){
		List <Student>student=sr.findByAgeLessThan(age);
		return student;
	}
	
	@DeleteMapping("/deletedatabyid")
	public String deleteStudent(@RequestParam int id) {
		sr.deleteById(id);
		return "data deleted ohkk";
		
	}
	
	
	@DeleteMapping("/deleteall")
	public String deleteAll() {
		sr.deleteAll();
		return "all data deleted";
	}
	 
	@PutMapping("/updatedata")
	public String updateStudent(@RequestBody Student s) {
		sr.save(s);
		return "data updated ohkk";
	}
	
	@GetMapping("/fetchdatabyequals")
	public List<Student> findStudentByAge(@RequestParam int age){
		return sr.findByAgeEquals(age);
	}
	
	
	
	@GetMapping("/graterthanequals")
	public List<Student>findByAgeGreaterThanEquals(@RequestParam int age){
		return  sr.findByAgeGreaterThanEqual(age);
		
		}
	
	@GetMapping("/lessthanequals")
	public List<Student>findByAgeLessThanEquals(int age){
		return sr.findByAgeLessThanEqual(age);
	}
	
	
	@GetMapping("/fetchdatabetween")
	public List<Student>findStudentBetweenAge(@RequestParam int age1,@RequestParam int age2){
		return sr.findByAgeBetween(age1,age2);
	}
	
	
	
	
		
	} 
	

