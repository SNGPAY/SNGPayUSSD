package com.sngpay.state;

public class SendMoneyState3 implements State{

	private int stateNumber;

	private String stateType;
	
	private State previousSate;
	
	public SendMoneyState3(String argStateType,int argStateNo) {
		
		stateType = argStateType;
		setStateNumber(argStateNo);
		
	}
	
	public SendMoneyState3(String argStateType){
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
		return "setPrivatePin1";
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
