package com.anurag.exception;

@SuppressWarnings("serial")
public class InvalidAmountException extends RuntimeException{

	public InvalidAmountException(String msg) {
		super(msg);	
	}

}
