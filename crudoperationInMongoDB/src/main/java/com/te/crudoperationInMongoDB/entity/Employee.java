package com.te.crudoperationInMongoDB.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private Integer id;
	private String empName;
	private Integer age;
	
	
	//private List<Department> departments;
}
