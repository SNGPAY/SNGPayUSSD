package com.sngpay.state;

public class SendMoneyState5 implements State{

	private int stateNumber;

	private String stateType;
	
	private State previousSate;
	
	public SendMoneyState5(String argStateType,int argStateNo) {
		
		setStateType(argStateType);
		setStateNumber(argStateNo);
		
	}
	
	public SendMoneyState5(String argStateType){
		setStateType(argStateType);
	}
	
	
	@Override
	public String getStateMenu() {
		// TODO Auto-generated method stub
		return "1. Enter the amount to send: \n00. Back" ;
	}

	@Override
	public int getStateNumber() {
		// TODO Auto-generated method stub
		return 0;
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

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public State getPreviousSate() {
		return previousSate;
	}

	public void setPreviousSate(State previousSate) {
		this.previousSate = previousSate;
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

	@Override
	public boolean isCheckLogicRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return "moneyTransfer";
	}

}
