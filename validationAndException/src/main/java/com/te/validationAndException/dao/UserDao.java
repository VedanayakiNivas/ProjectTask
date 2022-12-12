package com.te.validationAndException.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.validationAndException.bean.User;
import com.te.validationAndException.dto.UserRequest;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUserId(Integer id);

	

}
