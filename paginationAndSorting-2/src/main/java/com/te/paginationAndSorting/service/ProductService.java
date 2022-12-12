package com.te.paginationAndSorting.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.te.paginationAndSorting.bean.Product;


public interface ProductService {

	//public List<Product> initDB();
	public List<Product> getProducts();
	public List<Product> findProductWithSorting(String filed);
	public Page<Product> findProductWithPagination(Integer offset,Integer pageSize);
	public Page<Product> findProductWithPaginationAndSorting(Integer offset,Integer pageSize,String field);

	}
