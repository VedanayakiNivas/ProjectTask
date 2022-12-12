package com.te.implementCache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.implementCache.bean.Book;
import com.te.implementCache.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Book book){
		Book book2 = service.saveBook(book);
		return new ResponseEntity<String>("data saved",HttpStatus.OK);	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Book book = service.getBookById(id);
		return new ResponseEntity<Book> (book,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		Boolean byId = service.deleteById(id);
		return new ResponseEntity<Boolean>(byId,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Book book,@PathVariable Long id){
		Book book2 = service.updateBook(book,id);
		return new ResponseEntity<Book>(book2, HttpStatus.ACCEPTED);
	}
	
	
}
