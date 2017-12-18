package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sngpay.dao.USSDDBController;
import com.sngpay.dao.USSDDao;
import com.sngpay.dao.UserVerificationDBData;
import com.sngpay.exception.ErrorType;
import com.sngpay.exception.MoneyTransferException;
import com.sngpay.exception.StateCreationException;
import com.sngpay.state.LanguageState;
import com.sngpay.state.State;
import com.sngpay.state.StateGenerator;
import com.sngpay.transit.SendMoneyTransit;
import com.sngpay.util.LanguageType;

import hms.kite.samples.api.ussd.OperationType;
import hms.kite.samples.api.ussd.UssdRequestSender;
import hms.kite.samples.api.ussd.messages.MoUssdReq;
import hms.kite.samples.api.ussd.messages.MtUssdReq;

public class SendMoneyStateLogic {

	public static MtUssdReq setLanguageState(MoUssdReq arg0){
		
		MtUssdReq moUssdReq = new MtUssdReq();
		moUssdReq.setApplicationId(arg0.getApplicationId());
		moUssdReq.setPassword("PASSWD");
		moUssdReq.setDestinationAddress(arg0.getSourceAddress());
		moUssdReq.setSessionId(arg0.getSessionId());
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/USSDLabels");
		
		moUssdReq.setMessage(resourceBundle.getString("LanguageState.menu"));
		moUssdReq.setUssdOperation(OperationType.MT_CONT.getName());
		
		SendMoneyTransit moneyTransit = new SendMoneyTransit();
		moneyTransit.setMobileNumber(arg0.getSourceAddress());
		moneyTransit.setLanguageType(LanguageType.getEnum(arg0.getMessage()));
		
		UserVerificationDBData data = isRegistered(arg0);
		
		if(data != null && data.getVerificationChar().equalsIgnoreCase("Y") && data.getPIN() == null)
			moneyTransit.setRegistered(true);
		if(data != null && data.getPIN()!=null){
			System.out.println("PIN" + data.getPIN().toString());
			moneyTransit.setTemporaryPIN(data.getPIN().toString());
		}
		State languageState = new LanguageState("LanguageState");
		
		moneyTransit.setLastState(languageState);
		SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
		
		return moUssdReq;
	}
	
	public static MtUssdReq setlogic(MoUssdReq arg0){
		
		State lastState = SessionManager.getSession().get(arg0.getSourceAddress()).getLastState();
		Map<String,String> inputAndNextStateMap = SessionManager.getRulesMap().get(lastState.getStateType());
		System.out.println("***********" + lastState.getStateType()+ SessionManager.getSession().get(arg0.getSourceAddress()).isRegistered());
		Set<String> keySet = inputAndNextStateMap.keySet();
		
		String nextState = null;
		State currentState = null;
		MtUssdReq moUssdReq = new MtUssdReq();
		ErrorType errorType = ErrorType.SUCCESS;
		
		if(lastState.isUserInputTypeValue() == true && arg0.getMessage().equalsIgnoreCase("*")== false && keySet.size() == 2)
			nextState = inputAndNextStateMap.get("1");
		else if(lastState.isUserInputTypeValue() == true && arg0.getMessage().equalsIgnoreCase("*"))
			nextState = inputAndNextStateMap.get("*");
		else
			nextState = inputAndNextStateMap.get(arg0.getMessage());
		
		System.out.println("nextState" + nextState);
		
		try {
			currentState = StateGenerator.createStateInstance(nextState);
			System.out.println("Current state" + currentState);
			moUssdReq.setApplicationId(arg0.getApplicationId());
			moUssdReq.setPassword("PASSWD");
			moUssdReq.setDestinationAddress(arg0.getSourceAddress());
			moUssdReq.setSessionId(arg0.getSessionId());
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
			
			if(lastState.isCheckLogicRequired() && arg0.getMessage().equalsIgnoreCase("*") == false) {
				Method logicMethod = SendMoneyStateLogic.class.getMethod(lastState.getCheckLogicOf(), MoUssdReq.class);
				errorType = (ErrorType) logicMethod.invoke(logicMethod, arg0);
			}
			
			if(errorType != ErrorType.SUCCESS)
				setDetailAfterError(lastState, moUssdReq, arg0,errorType);
			}catch (InvocationTargetException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (StateCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		moUssdReq.setMessage(getMessage(arg0, nextState, null));
		return moUssdReq;
	}
	
	public static ErrorType checkPIN(MoUssdReq arg0){
		
		if(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePin1().equalsIgnoreCase(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePinRepeate()) == Boolean.FALSE) {
			
			return ErrorType.REPEATE_PIN_MISMATCH;
		}
		else {
			//DB call
		}
		
		return ErrorType.SUCCESS;
	}
	
	
	public static ErrorType moneyTransfer(MoUssdReq arg0) throws MoneyTransferException {
		// money transfer call
		
		return ErrorType.SUCCESS;
	}
	
	public static String getMessage(MoUssdReq arg0, String state,ErrorType errorType){
		
		String message = "";
		LanguageType languageType = SessionManager.getSession().get(arg0.getSourceAddress()).getLanguageType();
		
		Locale locale ;
		
		/*if(state.contentEquals("WelcomeState") )
			locale = new Locale(LanguageType.getEnum(arg0.getMessage()).getValue());
		else*/
			locale= new Locale(languageType.getValue());
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/USSDLabels", locale);
		
		if(state.contentEquals("WelcomeState") && SessionManager.getSession().get(arg0.getSourceAddress()).isRegistered() == true)
			return resourceBundle.getString("RegisteredWelcomeState.menu");
		
		message = resourceBundle.getString(state+".menu");
		if(errorType != null)
			message = resourceBundle.getString(errorType.name()+".msg")+"\n"+message;
		
		return message;
	}
	
	public static ErrorType checkMobileNumber(MoUssdReq arg0){
		
		if(arg0.getSourceAddress().contains(arg0.getMessage()) == Boolean.FALSE) return ErrorType.CONFIRM_MOBILE_FAIL;
		
		return ErrorType.SUCCESS;
		
	}
	
	public static ErrorType checkTemporaryPIN(MoUssdReq arg0){
		
		System.out.println("temp pin::" + SessionManager.getSession().get(arg0.getSourceAddress()).getTemporaryPIN());
		if(arg0.getMessage().equalsIgnoreCase(SessionManager.getSession().get(arg0.getSourceAddress()).getTemporaryPIN()))
			return ErrorType.SUCCESS;
		else return ErrorType.NOT_CORRECT_TEMPORARY_PIN;
	}
	
	public static ErrorType checkPINLength(MoUssdReq arg0){
	
		if(arg0.getMessage().length() > 4 || arg0.getMessage().length()<4)
			return ErrorType.NOT_4_DIGIT_PIN;
		return ErrorType.SUCCESS;
	}
	
	public static ErrorType registerPINConfirmation(MoUssdReq arg0){
		
		if(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePin1().equalsIgnoreCase(SessionManager.getSession().get(arg0.getSourceAddress()).getPrivatePinRepeate()) == Boolean.FALSE) 
			return ErrorType.REPEATE_PIN_MISMATCH;
		USSDDBController ussddbController = new USSDDBController();
		try {
			ussddbController.udateTemporaryStatus(arg0.getSourceAddress().substring(4, arg0.getSourceAddress().length()),arg0.getMessage());
			SessionManager.getSession().get(arg0.getSourceAddress()).setRegistered(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ErrorType.REGISTER_DB_FAILURE;
		}
		return ErrorType.SUCCESS;
		
	}
	
	public static UserVerificationDBData isRegistered(MoUssdReq arg0){
		USSDDBController controller = new USSDDBController();
		try {
			 return controller.getTemporaryPIN(arg0.getSourceAddress().substring(4, arg0.getSourceAddress().length()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String getBalance(MoUssdReq moUssdReq){
		
		USSDDBController controller = new USSDDBController();
		try {
			return String.valueOf(controller.getBalance(moUssdReq.getSourceAddress().substring(4, moUssdReq.getSourceAddress().length())));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return String.valueOf(BigDecimal.ZERO);
		}
	}
	
	public static void setDetailAfterError(State lastState,MtUssdReq moUssdReq,MoUssdReq arg0,ErrorType errorType) throws StateCreationException{
		String nextState = SessionManager.getErrorRulesMap().get(lastState.getStateType()).get(errorType);
		State toBeState = StateGenerator.createStateInstance(nextState);
		moUssdReq.setMessage(getMessage(arg0, toBeState.getStateType(), errorType));
		SendMoneyTransit moneyTransit = SessionManager.getSession().get(arg0.getSourceAddress());
		moneyTransit.setLastState(toBeState);
		SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
	}
}
