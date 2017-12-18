package com.sngpay.util;

public enum TVCompType {

	WIN_CABLE("WinCable",1),
	DISH_TV("DishTV",2),
	CC_TV("CCTV",3),
	AZAM_TV("AzamTV",4);
	
	private String value;
	private int flags;
	
	private TVCompType(String argValue, int argFlag) {
		value = argValue;
		flags = argFlag;
	}
	
	public String value(){
		return value;
	}
	
	public int flag(){
		return flags;
	}
	
	public static TVCompType getEnum(String arg){
		
		if(arg.contentEquals("1"))
			return TVCompType.WIN_CABLE;
	    if(arg.contentEquals("2"))
	    	return TVCompType.DISH_TV;
	    if(arg.contentEquals("3"))
	    	return TVCompType.CC_TV;
	    if(arg.contentEquals("3"))
	    	return TVCompType.AZAM_TV;
	    return null;
	}
	
	
	
	
}
