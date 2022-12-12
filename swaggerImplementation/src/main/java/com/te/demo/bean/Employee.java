package com.te.demo.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	//@NotEmpty
	@Size(min = 3,message = "min  should be 3 character")
	@Size(max = 15,message="max should be 15 character")
	private String empName;
	
	
	private String department;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;

}
