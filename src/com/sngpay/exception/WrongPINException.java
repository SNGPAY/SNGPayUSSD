package com.sngpay.exception;

public class WrongPINException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorType errorType;
	
	public WrongPINException(String errorMessage, ErrorType argErrorType ) {
		super(errorMessage);
		this.errorType = argErrorType;
	}
	
	public ErrorType getErrorType() {
		return errorType;
	}
	
}
