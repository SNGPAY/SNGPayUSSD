package com.sngpay.util;

public enum SendToProvider {

	TOGO_PESA("Togo Pesa",1),
	AIRTEL("AirTel",2),
	M_PESA("M-Pesa",3),
	EZY_PESA("Ezy Pesa",4),
	HALO_PESA("Halo Pesa",5);
	
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
			return SendToProvider.TOGO_PESA;
	    if(arg.contentEquals("2"))
	    	return SendToProvider.AIRTEL;
	    if(arg.contentEquals("3"))
	    	return SendToProvider.M_PESA;
	    if(arg.contentEquals("4"))
	    	return SendToProvider.EZY_PESA;
	    else return SendToProvider.HALO_PESA;
	}
}
