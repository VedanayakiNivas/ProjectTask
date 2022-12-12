package com.te.crudoperationInMongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "db_sequence")
public class Department {

	@Id
	private String deptId;
	private Integer seq;
	
}
