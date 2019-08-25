package com.projects.test.exception;

public class TransactionNotFoundException extends Exception {
	private Long transaction_id;
	public TransactionNotFoundException(Long transaction_id) {
	        super(String.format("Transaction is not found with id : '%s'", transaction_id));
	        }
	}