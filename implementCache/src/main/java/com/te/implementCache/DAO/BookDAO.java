package com.te.implementCache.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.implementCache.bean.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Long>{

	
}
