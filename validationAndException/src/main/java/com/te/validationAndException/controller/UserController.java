package com.te.validationAndException.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.te.validationAndException.bean.User;
import com.te.validationAndException.dto.UserRequest;
import com.te.validationAndException.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/signUp")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){

		return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/fetchById")
	public ResponseEntity<User> getUser(@PathVariable Integer id){
		return ResponseEntity.ok(service.getUser(id));
	}
	
	
	
}
