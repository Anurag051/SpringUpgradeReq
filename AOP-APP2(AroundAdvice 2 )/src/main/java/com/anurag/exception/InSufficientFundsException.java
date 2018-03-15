package com.anurag.exception;

@SuppressWarnings("serial")
public class InSufficientFundsException extends RuntimeException {

	public InSufficientFundsException(String msg) {
		super(msg);	
	}

}
