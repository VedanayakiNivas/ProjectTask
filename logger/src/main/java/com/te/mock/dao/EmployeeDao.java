package com.te.mock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.mock.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
