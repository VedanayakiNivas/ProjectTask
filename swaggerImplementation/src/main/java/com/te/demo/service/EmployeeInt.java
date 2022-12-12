package com.te.demo.service;

import java.util.List;

import com.te.demo.bean.Employee;

public interface EmployeeInt {

	public Employee register(Employee employee);
	
	public Boolean deleteById(Integer empId);
	
	public List<String> allEmployeeNames();
	
	public List<String> employeeAbv();
	
	public Employee fetch(Integer empId,String empName);

List<Employee> findByEmpNameLike(String likePatttern);

	
}
