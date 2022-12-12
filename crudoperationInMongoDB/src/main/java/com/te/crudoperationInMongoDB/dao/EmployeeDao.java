package com.te.crudoperationInMongoDB.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.te.crudoperationInMongoDB.entity.Employee;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, Integer>{

}
