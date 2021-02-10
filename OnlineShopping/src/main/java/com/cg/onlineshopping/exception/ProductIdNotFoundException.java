package com.cg.onlineshopping.exception;
/**
 * 
 * @author PAVITHRA
 *
 */
public class ProductIdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductIdNotFoundException() {
		super();
	}

	public ProductIdNotFoundException(String message) {
		super(message);
	}
	

}
