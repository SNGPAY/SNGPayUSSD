package com.sngpay.util;

public enum BillType {

	ELECTRICITY("Electricity",1),
	WATER("Water",2),
	TV("TV",3),
	UBER("UBER",4);
	
	private String value;
	private int flags;
	
	private BillType(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static BillType getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return BillType.ELECTRICITY;
	    if(arg.contentEquals("2"))
	    	return BillType.WATER;
	    if(arg.contentEquals("3"))
	    	return BillType.TV;
	    if(arg.contentEquals("3"))
	    	return BillType.UBER;
	    return null;
	}
	
	
}
