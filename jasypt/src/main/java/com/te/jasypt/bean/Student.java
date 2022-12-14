package com.te.jasypt.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Student {

	@Id
	private Integer id;
	private String first_name;
	private String last_name;
	private String city;
}
