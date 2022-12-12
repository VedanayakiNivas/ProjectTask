package com.te.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authenticate {

	private Integer empId;
	private String empName;
}
