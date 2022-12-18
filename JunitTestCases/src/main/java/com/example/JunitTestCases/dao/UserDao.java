package com.example.JunitTestCases.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JunitTestCases.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	List<User> findByAddress(String address); 
}
