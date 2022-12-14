package com.te.jasypt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.jasypt.bean.Student;
import com.te.jasypt.dao.StudentDao;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	public StudentDao dao;

	@Override
	public Student register(Student student) {
		return dao.save(student);
	}

	@Override
	public Student getById(Integer id) {
		return dao.findById(id).get();
	}
	
	
}
