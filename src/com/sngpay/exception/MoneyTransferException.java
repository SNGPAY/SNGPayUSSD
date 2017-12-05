package com.sngpay.exception;

public class MoneyTransferException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private ErrorType errorType;
	
	public MoneyTransferException(String errorMesg, ErrorType argErrorType) {
		
		super(errorMesg);
		this.errorType = argErrorType;
		
	}
	
	public ErrorType getErrorType() {
		
		return errorType;
	}
}
