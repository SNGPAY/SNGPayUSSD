package com.sngpay.transit;

import com.sngpay.state.State;
import com.sngpay.util.SendToProvider;

public class SendMoneyTransit {

	private String mobileNumber;
	private String sessionId;
	private String senderNumber;
	private String amountToSend;
	private String privatePin1;
	private String privatePinRepeate;
	private SendToProvider sendToProvider;
	private String stateName;
	private State lastState;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}
	public String getAmountToSend() {
		return amountToSend;
	}
	public void setAmountToSend(String amountToSend) {
		this.amountToSend = amountToSend;
	}
	public String getPrivatePin1() {
		return privatePin1;
	}
	public void setPrivatePin1(String privatePin1) {
		this.privatePin1 = privatePin1;
	}
	public String getPrivatePinRepeate() {
		return privatePinRepeate;
	}
	public void setPrivatePinRepeate(String privatePinRepeate) {
		this.privatePinRepeate = privatePinRepeate;
	}
	public SendToProvider getSendToProvider() {
		return sendToProvider;
	}
	public void setSendToProvider(String sendToProvider) {
		this.sendToProvider = SendToProvider.getEnum(sendToProvider);
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public State getLastState() {
		return lastState;
	}
	public void setLastState(State lastState) {
		this.lastState = lastState;
	}
		
}
