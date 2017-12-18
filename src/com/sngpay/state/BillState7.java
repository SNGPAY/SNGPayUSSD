package com.sngpay.state;

public class BillState7 implements State{
	
	private String stateType;
	
	private State previousSate;
	
	public State getPreviousSate() {
		return previousSate;
	}


	public void setPreviousSate(State previousSate) {
		this.previousSate = previousSate;
				 
	}


	public BillState7(String argStateType){
		stateType = argStateType;
	}
	
	public String getStateType() {
		return stateType;
	}


	public void setStateType(String stateType) {
		this.stateType = stateType;
	}


	@Override
	public String getOperaionToHold() {
		// TODO Auto-generated method stub
		return "setAmountToSend";
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
