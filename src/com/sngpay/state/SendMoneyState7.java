package com.sngpay.state;

public class SendMoneyState7 implements State{

	private int stateNumber;
	
	private String stateType;
	
	private State previousSate;
	
	public SendMoneyState7(String argStateType,int argStateNo) {
		
		setStateType(argStateType);
		setStateNumber(argStateNo);
		
	}
	
	public SendMoneyState7(String argStateType){
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
		return "setAmountToSend";
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

	@Override
	public boolean isUserInputTypeValue() {
		// TODO Auto-generated method stub
		return true;
	}


}
