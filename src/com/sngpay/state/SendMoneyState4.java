package com.sngpay.state;

public class SendMoneyState4 implements State{

	private int stateNumber;

	private String stateType;
	
	private State previousSate;
	
	public SendMoneyState4(String argStateType,int argStateNo) {
		
		this.stateType = argStateType;
		setStateNumber(argStateNo);
		
	}
	
	public SendMoneyState4(String argStateType){
		setStateType(argStateType);
	}
	
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
		return true;
	}

	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return "checkPIN";
	}

}
