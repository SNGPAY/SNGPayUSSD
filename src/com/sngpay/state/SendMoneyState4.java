package com.sngpay.state;

public class SendMoneyState4 implements State{

	@Override
	public String getStateMenu() {
		// TODO Auto-generated method stub
		return "1. Confirm your PIN: \n 00. Back";
	}

	@Override
	public int getStateNumber() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getStateType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOperaionToHold() {
		// TODO Auto-generated method stub
		return null;
	}

}
