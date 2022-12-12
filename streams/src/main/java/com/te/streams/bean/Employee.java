package com.te.streams.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
	public class Employee {

		@javax.persistence.Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer Id;
		private String name;
		private Integer age;
		private String gender;
		private String department;
		@JsonFormat(pattern = "dd/MM/yyyy")
		private String yearOfJoining;
		private double salary; 
		@OneToMany(cascade = CascadeType.ALL)
		private List<Address> address;

}
