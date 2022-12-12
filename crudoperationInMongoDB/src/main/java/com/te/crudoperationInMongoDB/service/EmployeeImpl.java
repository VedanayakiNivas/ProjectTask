package com.te.crudoperationInMongoDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.crudoperationInMongoDB.dao.EmployeeDao;
import com.te.crudoperationInMongoDB.entity.Employee;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private GenerateSequence generateSequence;

	@Override
	public Employee register(Employee employee) {

		return dao.insert(employee);
	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public String deleteById(Integer id) {

		dao.deleteById(id);
		return "deleted";
	}

	@Override
	public Employee update(Employee employee) {

		employee.setId(generateSequence.getSequenceNumber(Employee.SEQUENCE_NAME));
		return dao.save(employee);
	}

	

}
