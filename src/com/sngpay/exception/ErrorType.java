package com.sngpay.exception;

public enum ErrorType {

	REPEATE_PIN_MISMATCH("Confirmed PIN mismatching"),
	INVALID_PIN("Invalid PIN. Please Enter correct PIN"),
	MONEY_TRANSFER_FAIL("Transaction failed, Please try again"),
	SUCCESS("");
	
	private String errorString;
	
	private ErrorType(String argErrorString) {
		errorString = argErrorString;
	}
	
	public String getErrorString() {
		return errorString;
	}
}
