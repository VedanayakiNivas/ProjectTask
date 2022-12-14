package com.te.jasypt.service;

import com.te.jasypt.bean.Student;

public interface StudentService {

	public Student register(Student student);
	public Student getById(Integer id);
}
