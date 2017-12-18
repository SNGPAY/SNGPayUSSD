package com.sngpay.util;

public enum ElectricityCompType {

	TANESCO("Tanesco",1);
	
	
	private String value;
	private int flags;
	
	private ElectricityCompType(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static ElectricityCompType getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return ElectricityCompType.TANESCO;
	    return null;
	}
	
	
	
	
}
