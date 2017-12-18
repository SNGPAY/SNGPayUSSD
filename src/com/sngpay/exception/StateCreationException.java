package com.sngpay.exception;

public class StateCreationException extends Exception{

	private static final long serialVersionUID = 1L;

	private ErrorType errorType;
	
	public StateCreationException(String errorMessage, ErrorType argErrorType ) {
		super(errorMessage);
		this.errorType = argErrorType;
	}
	
	public ErrorType getErrorType() {
		return errorType;
	}
}
