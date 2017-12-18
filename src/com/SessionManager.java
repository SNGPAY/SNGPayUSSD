package com;

import java.util.HashMap;
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
		
		inputAndNextStepMap.put("1", "WelcomeState");
		inputAndNextStepMap.put("2", "WelcomeState");
		inputAndNextStepMap.put("3", "WelcomeState");
		
		currentStateMap.put("LanguageState", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("0", "RegisterState1");
		inputAndNextStepMap.put("1", "BalanceCheckState1");
		inputAndNextStepMap.put("2", "SendMoneyState1");
		inputAndNextStepMap.put("3", "WakalaState1");
		inputAndNextStepMap.put("4", "BillState1");
		inputAndNextStepMap.put("5", "SendMoneyState1");
		
		currentStateMap.put("WelcomeState", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "RegisterState2");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("RegisterState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "RegisterState3");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("RegisterState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WelcomeState");
		inputAndNextStepMap.put("*", "RegisterState2");
		currentStateMap.put("RegisterState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("BalanceCheckState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState6");
		inputAndNextStepMap.put("2", "SendMoneyState2");
		inputAndNextStepMap.put("3", "SendMoneyState2");
		inputAndNextStepMap.put("4", "SendMoneyState2");
		inputAndNextStepMap.put("5", "SendMoneyState2");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("SendMoneyState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState5");
		inputAndNextStepMap.put("*", "SendMoneyState1");
		currentStateMap.put("SendMoneyState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState3");
		inputAndNextStepMap.put("*", "SendMoneyState1");
		currentStateMap.put("SendMoneyState6", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState4");
		inputAndNextStepMap.put("*", "SendMoneyState2");
		currentStateMap.put("SendMoneyState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState5");
		inputAndNextStepMap.put("*", "SendMoneyState3");
		currentStateMap.put("SendMoneyState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState3");
		inputAndNextStepMap.put("*", "SendMoneyState2");
		currentStateMap.put("SendMoneyState5", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState8");
		inputAndNextStepMap.put("*", "SendMoneyState1");
		currentStateMap.put("SendMoneyState7", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WelcomeState");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("SendMoneyState8", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState2");
		inputAndNextStepMap.put("2", "BillState3");
		inputAndNextStepMap.put("3", "BillState4");
		inputAndNextStepMap.put("4", "BillState5");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("BillState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "SendMoneyState3");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState6");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState6");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState6");
		inputAndNextStepMap.put("2", "BillState6");
		inputAndNextStepMap.put("3", "BillState6");
		inputAndNextStepMap.put("4", "BillState6");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState6");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState5", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState7");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState6", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState8");
		inputAndNextStepMap.put("*", "BillState6");
		currentStateMap.put("BillState7", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState9");
		inputAndNextStepMap.put("*", "BillState7");
		currentStateMap.put("BillState8", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState10");
		inputAndNextStepMap.put("*", "BillState8");
		currentStateMap.put("BillState9", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "BillState11");
		inputAndNextStepMap.put("*", "BillState1");
		currentStateMap.put("BillState10", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("BillState11", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WakalaState2");
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("WakalaState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WakalaState3");
		inputAndNextStepMap.put("*", "WakalaState1");
		currentStateMap.put("WakalaState2", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WakalaState4");
		inputAndNextStepMap.put("*", "WakalaState2");
		currentStateMap.put("WakalaState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WakalaState5");
		inputAndNextStepMap.put("*", "WakalaState3");
		currentStateMap.put("WakalaState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("1", "WakalaState6");
		inputAndNextStepMap.put("*", "WakalaState1");
		currentStateMap.put("WakalaState5", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put("*", "WelcomeState");
		currentStateMap.put("WakalaState6", inputAndNextStepMap);
		
		
		
		rulesMap = currentStateMap;
		return rulesMap;
	}
	
	public static Map<String,Map<ErrorType, String>> getErrorRulesMap(){
		
		Map<ErrorType, String> inputAndNextStepMap = new HashMap<>();
		Map<String, Map<ErrorType, String>> currentStateMap = new HashMap<>();
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.REPEATE_PIN_MISMATCH, "SendMoneyState3");
		inputAndNextStepMap.put(ErrorType.INVALID_PIN, "SendMoneyState3");
		currentStateMap.put("SendMoneyState4", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.MONEY_TRANSFER_FAIL, "WelcomeState");
		currentStateMap.put("SendMoneyState5", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.REPEATE_PIN_MISMATCH, "RegisterState2");
		inputAndNextStepMap.put(ErrorType.NOT_4_DIGIT_PIN, "RegisterState2");
		inputAndNextStepMap.put(ErrorType.REGISTER_DB_FAILURE, "WelcomeState");
		currentStateMap.put("RegisterState3", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.NOT_CORRECT_TEMPORARY_PIN, "RegisterState1");
		currentStateMap.put("RegisterState1", inputAndNextStepMap);
		
		inputAndNextStepMap = new HashMap<>();
		inputAndNextStepMap.put(ErrorType.NOT_4_DIGIT_PIN, "RegisterState2");
		currentStateMap.put("RegisterState2", inputAndNextStepMap);
		
		/*inputAndNextStepMap = new HashMap<>();
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
