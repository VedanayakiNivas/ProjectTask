package com.te.streams.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.streams.bean.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
