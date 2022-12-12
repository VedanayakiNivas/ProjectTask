package com.te.implementCache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.te.implementCache.DAO.BookDAO;
import com.te.implementCache.bean.Book;

@Service
public class BookImpl implements BookService{

	@Autowired
	private BookDAO dao;
	
	@Override
	
	public Book saveBook(Book book) {
		
		return dao.save(book);
	}

	@Override
	@Cacheable(cacheNames = "books", key="#id")
	public Book getBookById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	  @CacheEvict(cacheNames = "books", key = "#id")
	public Boolean deleteById(Long id) {
		
		 dao.deleteById(id);
		 return true;
	}

	@Override
	@CachePut(cacheNames  = "books",key = "#id")
	public Book updateBook(Book book,Long id) {
	System.out.println("before cache update");
		Book book1 = dao.findById(id).get();
	book1.setName(book.getName());
	book1.setCategory(book.getCategory());
	book1.setAuthor(book.getAuthor());
	return dao.save(book1);
}

}
