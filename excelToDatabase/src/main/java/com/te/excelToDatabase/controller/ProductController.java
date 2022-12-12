package com.te.excelToDatabase.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.excelToDatabase.bean.Product;
import com.te.excelToDatabase.helper.Helper;
import com.te.excelToDatabase.service.ProductService;

@RestController
//@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> register(@RequestParam("file") MultipartFile file){
	if(Helper.checkExcelFormat(file)) {
		this.service.save(file);
		
		return ResponseEntity.ok(Map.of("message","File is uploaded"));
	}
	return new ResponseEntity<String>("please upload excel file",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/findAll")
	public List<Product> find(){
		return service.getAllProduct();
	}
}
