package com.example.JunitTestCases.service;

import java.util.List;

import com.example.JunitTestCases.bean.User;

public interface UserService {

	public User save(User user);
	public List<User> getUsers();
	public List<User> getUserByAddress(String address);
	public void deleteUser(User user);
}
