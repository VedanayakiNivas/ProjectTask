package com.te.demo.service;

public class InvalidException extends RuntimeException {

	String message;
	
	public InvalidException(String message) {
		super(message);
		this.message=message;
	}

	
}
