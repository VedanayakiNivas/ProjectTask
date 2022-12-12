package com.te.excelToDatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.excelToDatabase.bean.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
