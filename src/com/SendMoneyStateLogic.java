package com;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sngpay.state.State;
import com.sngpay.state.StateGenerator;
import com.sngpay.transit.SendMoneyTransit;

import hms.kite.samples.api.ussd.OperationType;
import hms.kite.samples.api.ussd.messages.MoUssdReq;
import hms.kite.samples.api.ussd.messages.MtUssdReq;

public class SendMoneyStateLogic {

	public static MtUssdReq setlogic(MoUssdReq arg0){
		
		State lastState = SessionManager.getSession().get(arg0.getSourceAddress()).getLastState();
		Map<String,String> inputAndNextStateMap = SessionManager.getRulesMap().get(lastState.getStateType());
		Set<String> keySet = inputAndNextStateMap.keySet();
		String nextState = null;
		State currentState = null;
		MtUssdReq moUssdReq = new MtUssdReq();
		
		if(keySet.size() >=1 )
			nextState = inputAndNextStateMap.get(arg0.getMessage());
		try {
			currentState = StateGenerator.createStateInstance(nextState);
			moUssdReq.setApplicationId(arg0.getApplicationId());
			moUssdReq.setPassword("PASSWD");
			moUssdReq.setDestinationAddress(arg0.getSourceAddress());
			moUssdReq.setSessionId(arg0.getSessionId());
			moUssdReq.setMessage(currentState.getStateMenu());
			moUssdReq.setUssdOperation(OperationType.MT_CONT.getName());
			
			if(SessionManager.getSession().get(arg0.getSourceAddress()) == null){
				SendMoneyTransit moneyTransit = new SendMoneyTransit();
				moneyTransit.setMobileNumber(arg0.getSourceAddress());
				SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
			}
			else{
				
				SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
				if(lastState.getOperaionToHold() != null && lastState.getOperaionToHold().trim().length() >0){
					Method method = moneyTransit.getClass().getMethod(lastState.getOperaionToHold(), String.class);
					method.invoke(moneyTransit, arg0.getMessage());
				}
				SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
			}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		return moUssdReq;
	}
	
}
