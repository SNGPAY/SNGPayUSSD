package com.sngpay.state;

public enum StateType {

	SEND_MONEY_TYPE("SendMoneyState");
	
	private String stateType;
	
	private StateType(String stateType) {
		this.stateType = stateType;
	}
	
}
