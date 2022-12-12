package com.te.excelToDatabase.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private String productDesc;
	private Long productPrice;

}
