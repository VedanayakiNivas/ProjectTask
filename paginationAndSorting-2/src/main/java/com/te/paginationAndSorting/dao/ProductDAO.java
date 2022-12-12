package com.te.paginationAndSorting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.paginationAndSorting.bean.Product;

@Repository

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
