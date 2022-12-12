package com.te.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mock.bean.Employee;
import com.te.mock.dao.EmployeeDao;

@Service
public class EmployeeImple implements EmployeeService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public Employee create(Employee employee) {
		
		return dao.save(employee);
	}

}
