package com;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sngpay.exception.ErrorType;
import com.sngpay.exception.MoneyTransferException;
import com.sngpay.exception.WrongPINException;
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
		ErrorType errorType = ErrorType.SUCCESS;
		
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
				moneyTransit.setLastState(currentState);
				SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
			}
			else{
				
				SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
				if(lastState.getOperaionToHold() != null && lastState.getOperaionToHold().trim().length() >0){
					Method method = moneyTransit.getClass().getMethod(lastState.getOperaionToHold(), String.class);
					method.invoke(moneyTransit, arg0.getMessage());
				}
				moneyTransit.setLastState(currentState);
				SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
			}
			
			if(lastState.isCheckLogicRequired()) {
				Method logicMethod = SendMoneyStateLogic.class.getMethod(lastState.getCheckLogicOf(), MoUssdReq.class);
				errorType = (ErrorType) logicMethod.invoke(logicMethod, arg0);
			}
				
			}catch (WrongPINException e) {
				if(e.getErrorType() == ErrorType.REPEATE_PIN_MISMATCH) {
					nextState = SessionManager.getErrorRulesMap().get(nextState).get(e.getErrorType());
					try {
						State toBeState = StateGenerator.createStateInstance(nextState);
						moUssdReq.setMessage(toBeState.getStateMenu());
						SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
						moneyTransit.setLastState(currentState);
						SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				if(e.getErrorType() == ErrorType.INVALID_PIN) {
					
					nextState = SessionManager.getErrorRulesMap().get(nextState).get(e.getErrorType());
					try {
						State toBeState = StateGenerator.createStateInstance(nextState);
						moUssdReq.setMessage(toBeState.getStateMenu());
						SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
						moneyTransit.setLastState(currentState);
						SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}	
			} 
		catch (MoneyTransferException e) {
			
			if(e.getErrorType() == ErrorType.MONEY_TRANSFER_FAIL) {
				
				nextState = SessionManager.getErrorRulesMap().get(nextState).get(e.getErrorType());
				try {
					State toBeState = StateGenerator.createStateInstance(nextState);
					moUssdReq.setMessage(toBeState.getStateMenu());
					SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
					moneyTransit.setLastState(currentState);
					SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
			
			
		}
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		return moUssdReq;
	}
	
	@SuppressWarnings("unused")
	private static ErrorType checkPIN(MoUssdReq arg0) throws WrongPINException{
		
		if(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePin1().equalsIgnoreCase(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePinRepeate()) == Boolean.FALSE) {
			
			throw  new WrongPINException("Confirmed PIN mismatching", ErrorType.REPEATE_PIN_MISMATCH);
		}
		else {
			//DB call
		}
		
		return ErrorType.SUCCESS;
	}
	
	@SuppressWarnings("unused")
	private static ErrorType moneyTransfer(MoUssdReq arg0) throws MoneyTransferException {
		// money transfer call
		
		return ErrorType.SUCCESS;
	}
}
