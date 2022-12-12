package com.te.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.demo.bean.Address;
import com.te.demo.bean.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	//String likePattern = "s%";
	//userRepository.findByNameLike("s%");
	
	List<Employee> findByEmpNameLike(String likePatttern);
}
