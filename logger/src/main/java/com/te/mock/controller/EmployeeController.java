package com.te.mock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mock.MockApplication;
import com.te.mock.bean.Employee;
import com.te.mock.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	Logger log = LoggerFactory.getLogger(MockApplication.class);
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/register")
	
	public ResponseEntity<?> save(@RequestBody Employee employee){
		log.error("errormsg");
		Employee employee2 = service.create(employee);
		
		return new ResponseEntity<String>("Data saved successfuly",HttpStatus.OK);
	}
	
}
