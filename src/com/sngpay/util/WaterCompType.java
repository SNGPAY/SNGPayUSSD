package com.sngpay.util;

public enum WaterCompType {

	DAWASCO("Dawasco",1);
	
	private String value;
	private int flags;
	
	private WaterCompType(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static WaterCompType getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return WaterCompType.DAWASCO;
	    return null;
	}
	
}
