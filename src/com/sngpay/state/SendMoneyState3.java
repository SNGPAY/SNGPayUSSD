package com.sngpay.state;

public class SendMoneyState3 implements State{

	@Override
	public String getStateMenu() {
		// TODO Auto-generated method stub
		return "1. Enter your PIN: \n 00. Back";
	}

	@Override
	public int getStateNumber() {
		// TODO Auto-generated method stub
		return 3;
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
