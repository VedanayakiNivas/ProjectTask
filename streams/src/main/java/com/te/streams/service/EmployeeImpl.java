package com.te.streams.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.streams.bean.Employee;
import com.te.streams.dao.EmployeeDao;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	public EmployeeDao dao;

	@Override
	public Employee register(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Boolean deleteById(Integer id) {
		dao.deleteById(id);
		return true;
	}

	@Override
	public Employee getById(Integer id) {

		return dao.findById(id).get();
	}

	@Override
	public List<String> getByDepartment(Employee employee) {
		 return dao.findAll().stream().filter(fl-> fl.getDepartment().equals("developer")).map(mp->mp.getName()).toList();
	}

	@Override
	public Map<String, List<Employee>> groupByDepartment(Employee employee) {
		
		 return  dao.findAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
		// return (List<String>) map;
	}

	@Override
	public Map<String, List<Employee>> birthdayWish(String dob) {
		
		return null;
	}

	@Override
	public Map<String, Long> maleAndFemaleEmployee(Employee employee){
		 Map<String, Long> collect = dao.findAll().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		 return collect;
	}
	
	@Override
	public Stream<String> getAllDepartment(Employee employee) {
	 	Stream<String> stream = dao.findAll().stream().map(Employee::getDepartment).distinct();
		return stream;
	}
	
	@Override
	public Employee getHighestSalaryEmployee(Employee employee) {
		Employee employee2 = dao.findAll().stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		return employee2;
	}


	@Override
	public List<String> joinAnniversaryWish(String yearOfJoining) {
		
		return dao.findAll()
				.stream()
				.filter(f->f.getYearOfJoining().contains(yearOfJoining.replaceAll("-", "/").substring(0, 5)))
				.map(mp->mp.getName()+" wishes for annivesaray!! ")
				.collect(Collectors.toList());
	}
	
}
