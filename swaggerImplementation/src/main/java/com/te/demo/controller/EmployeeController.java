package com.te.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.demo.bean.Authenticate;
import com.te.demo.bean.Employee;
import com.te.demo.service.EmployeeInt;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeInt service;
	
	@PostMapping("/register")
	public ResponseEntity<?> create(@Valid @RequestBody Employee employee){
		Employee employee2 = service.register(employee);
		return new ResponseEntity<String>("Data saved successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<?> delete(@PathVariable Integer empId ){
		Boolean id = service.deleteById(empId);
		return new ResponseEntity<String>("data deleted",HttpStatus.OK);
	}
	
	@GetMapping("/employee/all")
	public ResponseEntity<?> allEmployee(){
		List<String> list = service.allEmployeeNames();
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}	
	
	@GetMapping("/employee/abv4")
	public ResponseEntity<?> empabv(){
		List<String> list1 = service.employeeAbv();
		return new ResponseEntity<List<String>>(list1,HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<?> auth(@RequestBody Authenticate authenticate){
		Employee fetch = service.fetch(authenticate.getEmpId(), authenticate.getEmpName());
		if(fetch.getEmpId().equals(authenticate.getEmpId())&& fetch.getEmpName().equals(authenticate.getEmpName()))
		{
		return new ResponseEntity<Employee>(fetch,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("invalid",HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/namewiths")
	public ResponseEntity<?> nameWithS(String likePattern){
	List<Employee> findByEmpNameLike = service.findByEmpNameLike(likePattern);
	System.out.println(findByEmpNameLike);
		return new ResponseEntity<List<Employee>>(findByEmpNameLike,HttpStatus.OK);
	}

	
}
