package com.te.jasypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.jasypt.bean.Student;
import com.te.jasypt.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> register(@RequestBody Student student){
		Student student2 = service.register(student);
		return new ResponseEntity<String>("data saved",HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> get(@PathVariable Integer id){
		Student id2 = service.getById(id);
		return new ResponseEntity<Student> (id2,HttpStatus.OK);
	}
	
}
