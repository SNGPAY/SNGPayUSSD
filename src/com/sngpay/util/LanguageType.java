package com.sngpay.util;

public enum LanguageType {

	SWAHILI("sw","2"),
	FRENCH("fr","3"),
	ENGLISH("en","1");
	
	private String value;
	public String getValue() {
		return value;
	}

	private String number;
	
	public String getNumber() {
		return number;
	}

	private LanguageType(String argString,String number) {
		// TODO Auto-generated constructor stub
		value = argString;
		this.number = number;
	}
	
	public static LanguageType getEnum(String num){
		if(num.contentEquals("2"))
			return LanguageType.SWAHILI;
		if(num.contentEquals("3"))
			return LanguageType.FRENCH;
		return LanguageType.ENGLISH;
	}
}
