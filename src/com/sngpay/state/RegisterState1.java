package com.sngpay.state;

public class RegisterState1 implements State{

	private int stateNumber;

	private String stateType;
	
	private State previousSate;
	
	public RegisterState1(String argStateType,int argStateNo) {
		
		setStateType(argStateType);
		setStateNumber(argStateNo);
		
	}
	
	public RegisterState1(String argStateType){
		setStateType(argStateType);
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
		return true;
	}

	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return "checkTemporaryPIN";
	}

	@Override
	public boolean isUserInputTypeValue() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public State getPreviousSate() {
		return previousSate;
	}

	public void setPreviousSate(State previousSate) {
		this.previousSate = previousSate;
	}

	
}
