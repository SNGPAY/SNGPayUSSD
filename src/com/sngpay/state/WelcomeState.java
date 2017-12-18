package com.sngpay.state;

public class WelcomeState implements State{

	private String stateType;
	
	
	public WelcomeState(String argStateType){
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
		return "setLanguageType";
	}
	
	

	public void setStateType(String stateType) {
		this.stateType = stateType;
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
		return false;
	}

}
