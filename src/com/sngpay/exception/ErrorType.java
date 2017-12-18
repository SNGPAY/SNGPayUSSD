package com.sngpay.exception;

public enum ErrorType {

	REPEATE_PIN_MISMATCH("Confirmed PIN mismatching"),
	INVALID_PIN("Invalid PIN. Please Enter correct PIN"),
	MONEY_TRANSFER_FAIL("Transaction failed, Please try again"),
	STATE_CREATE_FAIL("State Creation Failed"),
	CONFIRM_MOBILE_FAIL("Confirm Mobile Number Failed"),
	NOT_4_DIGIT_PIN("The Entered PIN is not 4 digit"),
	NOT_CORRECT_TEMPORARY_PIN("Wrong PIN.Please Enter Correct Temporary PIN"),
	NOT_REGISTER_USER("You are not registered yet. Please contact your Agent"),
	DESTINATION_INCORRECT_MOBILE("Destination mobilenumber is not correct"),
	INCORRECT_BILL_NUMBER("Wrong bill number entered"),
	INSUFFICIENT_FUND("You don't have enough fund for this transaction"),
	REGISTER_DB_FAILURE("Something went wrong.Please try to Register later"),
	SUCCESS("");
	
	private String errorString;
	
	private ErrorType(String argErrorString) {
		errorString = argErrorString;
	}
	
	public String getErrorString() {
		return errorString;
	}
}
