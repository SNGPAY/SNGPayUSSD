package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sngpay.transit.SendMoneyTransit;

public class SessionManager {

	
	public static Map<String, SendMoneyTransit> sessionMap = new HashMap<String,SendMoneyTransit>();
	
	public static Map<String,Map<String, String> > rulesMap = new HashMap<>();
	
	public static void addSession(String mobileNumber,SendMoneyTransit argMoneyTransit){
		sessionMap.put(mobileNumber, argMoneyTransit);
	}
	
	public static Map<String, SendMoneyTransit> getSession(){
		
		return sessionMap;
		
	}
	
	public static Map<String,Map<String, String>> getRulesMap(){
		
		Map<String, String> inputAndNextStepMap = new HashMap<>();
		Map<String, Map<String, String>> currentStateMap = new HashMap<>();
		
		inputAndNextStepMap.put("1", "SendMoneyState1");
		
		currentStateMap.put("WelcomeState", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae2");
		
		currentStateMap.put("SendMoneyState1", inputAndNextStepMap);
		
		
		
		
		rulesMap = currentStateMap;
		return rulesMap;
	}
}
