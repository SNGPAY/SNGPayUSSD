package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sngpay.exception.ErrorType;
import com.sngpay.transit.SendMoneyTransit;

public class SessionManager {

	
	public static Map<String, SendMoneyTransit> sessionMap = new HashMap<String,SendMoneyTransit>();
	
	public static Map<String,Map<String, String> > rulesMap = new HashMap<>();
	
	public static Map<String,Map<ErrorType, String> > errorRulesMap = new HashMap<>();
	
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
		inputAndNextStepMap.put("2", "SendMoneyState1");
		inputAndNextStepMap.put("3", "SendMoneyState1");
		inputAndNextStepMap.put("4", "SendMoneyState1");
		inputAndNextStepMap.put("5", "SendMoneyState1");
		inputAndNextStepMap.put("6", "SendMoneyState1");
		
		currentStateMap.put("WelcomeState", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae2");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("SendMoneyState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae3");
		inputAndNextStepMap.put("*", "SendMoneyState1");
		currentStateMap.put("SendMoneyState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae4");
		inputAndNextStepMap.put("*", "SendMoneyState2");
		currentStateMap.put("SendMoneyState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae5");
		inputAndNextStepMap.put("*", "SendMoneyState3");
		currentStateMap.put("SendMoneyState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WelcomeState");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("SendMoneyState5", inputAndNextStepMap);
		
		
		rulesMap = currentStateMap;
		return rulesMap;
	}
	
	public static Map<String,Map<ErrorType, String>> getErrorRulesMap(){
		
		Map<ErrorType, String> inputAndNextStepMap = new HashMap<>();
		Map<String, Map<ErrorType, String>> currentStateMap = new HashMap<>();
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.REPEATE_PIN_MISMATCH, "SendMoneyStae3");
		inputAndNextStepMap.put(ErrorType.INVALID_PIN, "SendMoneyStae3");
		currentStateMap.put("SendMoneyState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.MONEY_TRANSFER_FAIL, "WelcomeState");
		currentStateMap.put("SendMoneyState5", inputAndNextStepMap);
		
		/*inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae4");
		inputAndNextStepMap.put("*", "SendMoneyState2");
		currentStateMap.put("SendMoneyState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyStae5");
		inputAndNextStepMap.put("*", "SendMoneyState3");
		currentStateMap.put("SendMoneyState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WelcomeState");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("SendMoneyState5", inputAndNextStepMap);*/
		
		
		errorRulesMap = currentStateMap;
		return errorRulesMap;
	}
}
