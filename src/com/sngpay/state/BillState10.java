package com.sngpay.state;

public class BillState10 implements State{

	private String stateType;
	
	private State previousSate;
	
	public State getPreviousSate() {
		return previousSate;
	}


	public void setPreviousSate(State previousSate) {
		this.previousSate = previousSate;
				 
	}

	public BillState10(String argStateType){
		stateType = argStateType;
	}

	
	public BillState10() {
		// TODO Auto-generated constructor stub
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


	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

}
