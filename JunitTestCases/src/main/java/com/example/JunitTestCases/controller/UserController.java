package com.example.JunitTestCases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JunitTestCases.bean.User;
import com.example.JunitTestCases.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User  user){
		User user2 = service.save(user);
		return new ResponseEntity<String>("Data Saved",HttpStatus.OK);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUser(){
		List<User> list = service.getUsers();
		return new ResponseEntity<List<User>> (list,HttpStatus.OK);	
	}
	
	@GetMapping("/getUserByAddress/{address}")
	public ResponseEntity<?> getUserByAddress(@PathVariable String address){
		List<User> list = service.getUserByAddress(address);
		return new ResponseEntity<List<User>>( list,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(User user){
		service.deleteUser(user);
		return new ResponseEntity<String>("deleted Successfully",HttpStatus.OK);
	}
}
