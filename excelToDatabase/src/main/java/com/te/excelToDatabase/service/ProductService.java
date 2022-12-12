package com.te.excelToDatabase.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.te.excelToDatabase.bean.Product;

public interface ProductService {

	public void save(MultipartFile file);
	public List<Product> getAllProduct();
	
}
