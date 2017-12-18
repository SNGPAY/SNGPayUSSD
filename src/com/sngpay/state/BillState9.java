package com.sngpay.state;

public class BillState9 implements State{
	
	private String stateType;
	
	public BillState9(String argStateType){
		stateType = argStateType;
	}

	public String getStateType() {
		return stateType;
	}

	@Override
	public String getOperaionToHold() {
		// TODO Auto-generated method stub
		return "setPrivatePinRepeate";
	}


	@Override
	public boolean isCheckLogicRequired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String getCheckLogicOf() {
		// TODO Auto-generated method stub
		return "registerPINConfirmation";
	}


	@Override
	public boolean isUserInputTypeValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
