package com.te.crudoperationInMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.crudoperationInMongoDB.entity.Employee;
import com.te.crudoperationInMongoDB.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		
		Employee employee2 = service.register(employee);
		return new ResponseEntity<String>("Data saved", HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		List<Employee> findAll = service.findAll();
		return new ResponseEntity<List<Employee>>(findAll,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		String byId = service.deleteById(id);
		return new ResponseEntity<String>("EmployeeId "+id+": is deleted successfully",HttpStatus.OK);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Employee employee){
		Employee employee2 = service.update(employee);
		return new ResponseEntity<Employee>(employee2,HttpStatus.OK);
	}
	
	
}
