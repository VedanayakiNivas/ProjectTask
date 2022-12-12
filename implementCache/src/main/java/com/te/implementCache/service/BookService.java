package com.te.implementCache.service;

import com.te.implementCache.bean.Book;

public interface BookService {

	public Book saveBook(Book book);
	public Book getBookById(Long id);
	public Boolean deleteById(Long id);
	
	 public Book updateBook(Book book, Long id);
}
