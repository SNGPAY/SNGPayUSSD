package com.sngpay.state;

public class SendMoneyState2 implements State{

	private int stateNumber;

	private String stateType;
	
	private State previousSate;

	public SendMoneyState2(String argStateType,int argStateNo) {
		
		stateType = argStateType;
		setStateNumber(argStateNo);
		
	}
	
	public SendMoneyState2(String argStateType){
		stateType = argStateType;
	}
	
	
	@Override
	public String getStateMenu() {
		return "Enter Account Number: \n";
	}

	@Override
	public int getStateNumber() {
		return 2;
	}

	@Override
	public String getStateType() {
		return stateType;
	}

	@Override
	public String getOperaionToHold() {
		return "setSenderNumber";
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	public State getPreviousSate() {
		return previousSate;
	}

	public void setPreviousSate(State previousSate) {
		this.previousSate = previousSate;
	}

}
