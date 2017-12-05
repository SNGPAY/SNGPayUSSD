package com.sngpay.state;

public class WelcomeState implements State{

	private int stateNumber;
	
	private String stateType;
	
	private State previousSate;
	
	public WelcomeState(String argStateType,int argStateNo) {
		
		stateType = argStateType;
		setStateNumber(argStateNo);
		
	}
	
	public WelcomeState(String argStateType){
		stateType = argStateType;
	}
	
	@Override
	public String getStateMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStateNumber() {
		// TODO Auto-generated method stub
		return 0;
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
	
	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
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

}
