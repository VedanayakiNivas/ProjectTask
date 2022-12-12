package com.te.excelToDatabase.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.excelToDatabase.bean.Product;
import com.te.excelToDatabase.dao.ProductDao;
import com.te.excelToDatabase.helper.Helper;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public void save(MultipartFile file) {
		Helper helper= new Helper();
		try {
			List<Product> product = helper.convertExcelToListOfProduct(file.getInputStream());
			this.dao.saveAll(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProduct() {
		
		return this.dao.findAll();
	}
	
	
	
}
