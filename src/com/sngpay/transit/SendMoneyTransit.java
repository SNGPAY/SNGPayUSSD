package com.sngpay.transit;

import com.sngpay.state.State;
import com.sngpay.util.BillType;
import com.sngpay.util.ElectricityCompType;
import com.sngpay.util.LanguageType;
import com.sngpay.util.SendToProvider;
import com.sngpay.util.TVCompType;
import com.sngpay.util.UBERType;
import com.sngpay.util.WaterCompType;

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
	private LanguageType languageType;
	private BillType billType;
	private ElectricityCompType electricityCompType;
	private WaterCompType waterCompType;
	private TVCompType tvCompType;
	private UBERType uberType;
	private boolean registered;
	private String temporaryPIN;
	
	public LanguageType getLanguageType() {
		return languageType;
	}
	public void setLanguageType(String languageType) {
		this.languageType = LanguageType.getEnum(languageType);
	}
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
	public BillType getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = BillType.getEnum(billType);
	}
	public ElectricityCompType getElectricityCompType() {
		return electricityCompType;
	}
	public void setElectricityCompType(String electricityCompType) {
		this.electricityCompType = ElectricityCompType.getEnum(electricityCompType);
	}
	public WaterCompType getWaterCompType() {
		return waterCompType;
	}
	public void setWaterCompType(String waterCompType) {
		this.waterCompType = WaterCompType.getEnum(waterCompType);
	}
	public TVCompType getTvCompType() {
		return tvCompType;
	}
	public void setTvCompType(String tvCompType) {
		this.tvCompType = TVCompType.getEnum(tvCompType);
	}
	public UBERType getUberType() {
		return uberType;
	}
	public void setUberType(String uberType) {
		this.uberType = UBERType.getEnum(uberType);
	}
	public void setSendToProvider(SendToProvider sendToProvider) {
		this.sendToProvider = sendToProvider;
	}
	public void setLanguageType(LanguageType languageType) {
		this.languageType = languageType;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	public String getTemporaryPIN() {
		return temporaryPIN;
	}
	public void setTemporaryPIN(String temporaryPIN) {
		this.temporaryPIN = temporaryPIN;
	}
		
}
