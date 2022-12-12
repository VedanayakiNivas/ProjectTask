package com.te.crudoperationInMongoDB.service;

import java.util.List;

import com.te.crudoperationInMongoDB.entity.Employee;

public interface EmployeeService {

	public Employee register(Employee employee);
	public List<Employee> findAll();
	public String deleteById(Integer id);
	public Employee update(Employee employee);
	//public Integer getSequenceNumber(String sequenceName);
}
