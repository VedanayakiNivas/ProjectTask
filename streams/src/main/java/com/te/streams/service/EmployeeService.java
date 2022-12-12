package com.te.streams.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.te.streams.bean.Employee;

public interface EmployeeService {

	public Employee register(Employee employee);
	
	public Boolean deleteById(Integer id);

	public Employee getById(Integer id);
	
	public List<String> getByDepartment(Employee employee);
	
	public Map<String, List<Employee>> groupByDepartment(Employee employee);
	
	public Map<String, List<Employee>> birthdayWish(String dob) ;
	
	public Map<String, Long> maleAndFemaleEmployee(Employee employee);
	
	public Stream<String> getAllDepartment(Employee employee);
	
	public Employee getHighestSalaryEmployee(Employee employee);

	public List<String> joinAnniversaryWish(String yearOfJoining);
}
