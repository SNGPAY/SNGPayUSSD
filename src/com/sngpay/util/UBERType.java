package com.sngpay.util;

public enum UBERType {

	UBER("UBER",1);

	private String value;
	private int flags;
	
	private UBERType(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static UBERType getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return UBERType.UBER;
	    
	    return null;
	}
	
	


	
}
