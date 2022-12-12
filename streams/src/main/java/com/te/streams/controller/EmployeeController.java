package com.te.streams.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.streams.bean.Employee;
import com.te.streams.dao.EmployeeDao;
import com.te.streams.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		Employee register = service.register(employee);
		return new ResponseEntity<String>("Data Saved", HttpStatus.OK);

	}

	// save only if department is developer
	@PostMapping("/save/developer")
	public ResponseEntity<?> saveDeveloper(@RequestBody Employee employee) {
		Employee emp = service.register(employee);
		if (employee.getDepartment().equals("developer")) {
			return new ResponseEntity<String>("Data Saved", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Employee Data not Saved because dept is not developer", HttpStatus.OK);
		}

	}
	
	//get all developer
	@GetMapping("/getDeveloper")
	public ResponseEntity<?> getDeveloper( Employee employee){
		List<String> byDepartment = service.getByDepartment(employee);
		return new ResponseEntity<List<String>>(byDepartment,HttpStatus.OK);
	}
	//grouping by department
	@GetMapping("/groupByDepartment")
	public ResponseEntity<?> groupByDeveloper(Employee employee){
		Map<String, List<Employee>> groupByDepartment = service.groupByDepartment(employee);
		
		return new ResponseEntity<Map<String, List<Employee>>>(groupByDepartment,HttpStatus.OK);
	}
	
	//How many male and female employees are there in the organization?
	@GetMapping("/count")
	public ResponseEntity<?> getMaleAndFemaleCount(Employee employee){
		Map<String, Long> maleAndFemaleEmployee = service.maleAndFemaleEmployee(employee);
		return new ResponseEntity<Map<String, Long>> (maleAndFemaleEmployee,HttpStatus.OK);
	}
	
	//Print the name of all departments in the organization
	@GetMapping("/getAllDept")
	public ResponseEntity<?> getAllDepartment(Employee employee){
		Stream<String> allDepartment = service.getAllDepartment(employee);
		return new ResponseEntity<Stream<String>>(allDepartment,HttpStatus.OK);
	}
	
	//Get the details of highest paid employee in the organization
	@GetMapping("/getHighestSalary")
	public ResponseEntity<?> getHighestSalaryEmployee(Employee employee){
		Employee highestSalaryEmployee = service.getHighestSalaryEmployee(employee);
		return new ResponseEntity<Employee>(highestSalaryEmployee,HttpStatus.OK);
	}
	
	//Wishing employee for his working anniversary
	@GetMapping("/wish/{date}")
	public ResponseEntity<?> wishingEmployee(@PathVariable("date") String yearOfJoining){
		List<String> joinAnniversaryWish = service.joinAnniversaryWish(yearOfJoining);
		return new ResponseEntity<List<String>>(joinAnniversaryWish,HttpStatus.ACCEPTED);
	}
}
