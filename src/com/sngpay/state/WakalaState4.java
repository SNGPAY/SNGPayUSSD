package com.sngpay.state;

public class WakalaState4 implements State{

	private String stateType;
	
	public WakalaState4(String argStateType) {
		// TODO Auto-generated constructor stub
		stateType = argStateType;
	}
	
	@Override
	public String getStateType() {
		// TODO Auto-generated method stub
		return stateType;
	}

	@Override
	public String getOperaionToHold() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCheckLogicRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserInputTypeValue() {
		// TODO Auto-generated method stub
		return true;
	}

}
