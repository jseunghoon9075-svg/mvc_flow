package com.app.exception;

public class ProductExceptionController extends RuntimeException{
	public ProductExceptionController() {;}

	public ProductExceptionController(String message) {
		super(message);
	}
	
	
}
