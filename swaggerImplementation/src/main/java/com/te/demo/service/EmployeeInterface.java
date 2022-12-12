package com.te.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.demo.bean.Employee;
import com.te.demo.dao.EmployeeDao;

@Service
public class EmployeeInterface implements EmployeeInt{

	@Autowired
	public EmployeeDao dao;
	
	
	@Override
	public Employee register(Employee employee) {
	if(employee.getDepartment().equals("developer")) {
		return dao.save(employee);
			}
	else {
			throw new InvalidException("Department not matched ");
			}}
	

	@Override
	public Boolean deleteById(Integer empId) {
		 dao.deleteById(empId);
		 return true;
	}

	@Override
	public List<String> allEmployeeNames() {
		
		return dao.findAll().stream().map(mp ->{
			StringBuilder sb= new StringBuilder();
			sb.append(mp.getEmpName());
			sb.append("happy birthday");
			return sb.toString();
		}).toList();
	}

	@Override
	public List<String> employeeAbv() {
		

		 return dao.findAll().stream().filter(fl -> fl.getEmpId()>3).map(mp->mp.getEmpName()).toList();
	
		}

	@Override
	public Employee fetch(Integer empId, String empName) {
		
		return dao.findById(empId).get();
	}

	

	


	@Override
	public List<Employee> findByEmpNameLike(String likePatttern) {
		String likePattern = "s%";
		 List<Employee> findByEmpNameLike =  dao.findByEmpNameLike(likePattern);
		 System.out.println(findByEmpNameLike);
		return findByEmpNameLike;
		 //return dao.findByEmpNameLike(likePatttern);
	}

//	@Override
//	public List<String> allEmployeeNames() {
//		return dao.findAll().stream().map(mp->{
//			StringBuilder sb = new StringBuilder();
//			sb.append(mp.getEmpName());
//			sb.append(" Happy Birthday");
//			return sb.toString();
//		}).toList();
//	}
	
	

}
