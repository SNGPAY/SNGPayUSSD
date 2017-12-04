package com;
import java.net.MalformedURLException;
import java.net.URL;

import com.sngpay.state.State;
import com.sngpay.state.StateGenerator;
import com.sngpay.state.StateType;
import com.sngpay.transit.SendMoneyTransit;

import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.ussd.MoUssdListener;
import hms.kite.samples.api.ussd.OperationType;
import hms.kite.samples.api.ussd.UssdRequestSender;
import hms.kite.samples.api.ussd.messages.MoUssdReq;
import hms.kite.samples.api.ussd.messages.MtUssdReq;

public class USSDMainMenu implements MoUssdListener{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReceivedUssd(MoUssdReq arg0) {
		
		System.out.println("Hi"+ arg0.getUssdOperation()+arg0.getMessage());
		if(arg0.getUssdOperation().equalsIgnoreCase(OperationType.MO_INIT.getName())){
			MtUssdReq moUssdReq = new MtUssdReq();
			moUssdReq.setApplicationId("APP_000001");
			moUssdReq.setPassword("PASSWD");
			moUssdReq.setDestinationAddress(arg0.getSourceAddress());
			moUssdReq.setMessage("Welcome to SnGPay \n Choose \n 1. Register \n 2. Balance \n 3. Send \n 4. Wakala \n 5.Bill \n 6.Change Password");
			moUssdReq.setSessionId(arg0.getSessionId());
			moUssdReq.setUssdOperation(OperationType.MT_CONT.getName());
			SendMoneyTransit moneyTransit = new SendMoneyTransit();
			moneyTransit.setMobileNumber(arg0.getSourceAddress());
			try {
				State welcomeState = StateGenerator.createStateInstance("WelcomeState");
				moneyTransit.setLastState(welcomeState);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SessionManager.addSession(moneyTransit.getMobileNumber(), moneyTransit);
			
			try {
				UssdRequestSender requestSender = new UssdRequestSender(new URL("http://127.0.0.1:7000/ussd/send"));
				requestSender.sendUssdRequest(moUssdReq);
			} catch (MalformedURLException | SdpException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			MtUssdReq moUssdReq = new MtUssdReq();
			if(arg0.getMessage().contentEquals(new StringBuffer("1"))){
				System.out.println("Hi2");
				
				moUssdReq = SendMoneyStateLogic.setlogic(arg0);
				
				try {
					UssdRequestSender requestSender = new UssdRequestSender(new URL("http://127.0.0.1:7000/ussd/send"));
					requestSender.sendUssdRequest(moUssdReq);
				} catch (MalformedURLException | SdpException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			/*SendMoneyTransit moneyTransit = new SendMoneyTransit();
			if( moneyTransit.getLastState().getStateType().equals(StateType.SEND_MONEY_TYPE.name())) 
				SendMoneyStateLogic.setlogic(arg0);*/
			
		}
	}

}
