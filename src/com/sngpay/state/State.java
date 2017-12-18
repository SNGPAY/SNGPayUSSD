package com.sngpay.state;

public interface State {

	public String getStateType();
	public String getOperaionToHold();
	public boolean isCheckLogicRequired();
	public String getCheckLogicOf();
	public boolean isUserInputTypeValue();
	
}
