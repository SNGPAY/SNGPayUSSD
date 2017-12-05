package com.sngpay.state;

public interface State {

	public String getStateMenu();
	public int getStateNumber();
	public String getStateType();
	public String getOperaionToHold();
	public boolean isCheckLogicRequired();
	public String getCheckLogicOf();
	
}
