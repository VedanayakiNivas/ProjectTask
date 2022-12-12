package com.te.paginationAndSorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.paginationAndSorting.bean.Product;
import com.te.paginationAndSorting.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<?> getProducts(){
		List<Product> products = service.getProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/{field}")
	public ResponseEntity<List<Product>> getPRoductsWithSorting(@PathVariable String field){
		List<Product> products= service.findProductWithSorting(field);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public ResponseEntity<Page<Product>> getProductWithPagination(@PathVariable Integer offset,@PathVariable Integer pageSize){
		Page<Product> products=service.findProductWithPagination(offset, pageSize);
		return new ResponseEntity<Page<Product>>(products,HttpStatus.OK);
		
	}
	
	@GetMapping("/paginationAndSorting/{offset}/{pageSize}/{field}")
	public ResponseEntity<Page<Product>> getProductWithPaginationAndSorting(@PathVariable Integer offset,@PathVariable Integer pageSize,@PathVariable String field){
		Page<Product> findProductWithPaginationAndSorting = service.findProductWithPaginationAndSorting(offset, pageSize, field);
		return new ResponseEntity<Page<Product>>(findProductWithPaginationAndSorting,HttpStatus.OK);
	}
	
	
}
