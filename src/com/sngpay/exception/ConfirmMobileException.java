package com.sngpay.exception;

public class ConfirmMobileException extends Exception{

private ErrorType errorType;
	
	public ConfirmMobileException(String errorMessage, ErrorType argErrorType ) {
		super(errorMessage);
		this.errorType = argErrorType;
	}
	
	public ErrorType getErrorType() {
		return errorType;
	}
}
