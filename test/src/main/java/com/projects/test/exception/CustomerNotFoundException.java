package com.projects.test.exception;

public class CustomerNotFoundException extends Exception {
	private Long customer_id;
	public CustomerNotFoundException(Long customer_id) {
	        super(String.format("Customer is not found with id : '%s'", customer_id));
	        }
	}