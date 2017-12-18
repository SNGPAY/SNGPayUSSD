package com.sngpay.state;

public class BalanceCheckState1 implements State{

	private int stateNumber;

	private String stateType;

	public BalanceCheckState1(String argStateType,int argStateNo) {
		
		stateType = argStateType;
		stateNumber = argStateNo;
		
	}
	
	public BalanceCheckState1(String argStateType){
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
		return true;
	}

	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return "getBalance";
	}

	@Override
	public boolean isUserInputTypeValue() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public void setStateNumber(int stateNumber) {
		this.stateNumber = stateNumber;
	}

}
