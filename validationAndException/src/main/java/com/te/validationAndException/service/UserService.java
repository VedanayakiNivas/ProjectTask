package com.te.validationAndException.service;

import java.util.List;

import com.te.validationAndException.bean.User;
import com.te.validationAndException.dto.UserRequest;

public interface UserService {

	public User saveUser(UserRequest userRequest);
	public List<User> getAllUsers();
	public User getUser(Integer id);
}
