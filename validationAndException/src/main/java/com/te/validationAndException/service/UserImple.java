package com.te.validationAndException.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.validationAndException.bean.User;
import com.te.validationAndException.dao.UserDao;
import com.te.validationAndException.dto.UserRequest;

@Service
public class UserImple implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public User saveUser(UserRequest userRequest) {
		
		User user = new User(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return dao.save(user);
	}

	public List<User> getAllUsers(){
		return dao.findAll();
	}
	
	public User getUser(Integer id) {
		return dao.findByUserId(id);
	}
}
