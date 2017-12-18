package com.sngpay.util;

public enum SendToProvider {

	SNGPAY("SNGPay",1),
	TIGO_PESA("Tigo Pesa",2),
	AIRTEL("AirTel",3),
	M_PESA("M-Pesa",4),
	EZY_PESA("Ezy Pesa",5),
	HALO_PESA("Halo Pesa",6);
	
	private String value;
	private int flags;
	
	private SendToProvider(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static SendToProvider getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return SendToProvider.SNGPAY;
	    if(arg.contentEquals("2"))
	    	return SendToProvider.TIGO_PESA;
	    if(arg.contentEquals("3"))
	    	return SendToProvider.AIRTEL;
	    if(arg.contentEquals("4"))
	    	return SendToProvider.M_PESA;
	    if(arg.contentEquals("5"))
	    	return EZY_PESA;
	    else return SendToProvider.HALO_PESA;
	}
}
