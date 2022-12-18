package com.example.JunitTestCases.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JunitTestCases.bean.User;
import com.example.JunitTestCases.dao.UserDao;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User save(User user) {
		
		return dao.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return dao.findAll();
	}

	@Override
	public List<User> getUserByAddress(String address) {
	
		return dao.findByAddress(address);
	}

	@Override
	public void deleteUser(User user) {
		 dao.delete(user);
		
	}

}
