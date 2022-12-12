package com.te.paginationAndSorting.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.te.paginationAndSorting.bean.Product;
import com.te.paginationAndSorting.dao.ProductDAO;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	private ProductDAO dao;

//	@PostConstruct
//	public List<Product> initDB() {
//		List<Product> products = IntStream.rangeClosed(1, 200).mapToObj(i -> new Product(new Random().nextInt(),
//				"product" + i, new Random().nextInt(100), new Random().nextInt(50000))).collect(Collectors.toList());
//		return dao.saveAll(products);
//	
//}

	@Override
	public List<Product> getProducts() {
		 return dao.findAll();
	}

	@Override
	public List<Product> findProductWithSorting(String field) {
		return dao.findAll(Sort.by(Sort.Direction.DESC,field));
	}

	@Override
	public Page<Product> findProductWithPagination(Integer offset, Integer pageSize) {
		
		Page<Product> product= dao.findAll(PageRequest.of(offset, pageSize));
		return product;
	}

	@Override
	public Page<Product> findProductWithPaginationAndSorting(Integer offset, Integer pageSize, String field) {
		return dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
	}


	
	
}
