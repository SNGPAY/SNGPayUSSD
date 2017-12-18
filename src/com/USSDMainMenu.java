package com;
import java.net.MalformedURLException;
import java.net.URL;

import com.sngpay.state.LanguageState;
import com.sngpay.state.State;
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
		
		
		if(arg0.getUssdOperation().equalsIgnoreCase(OperationType.MO_INIT.getName())){
			System.out.println("Hi"+ arg0.getUssdOperation()+arg0.getMessage());
			MtUssdReq moUssdReq = new MtUssdReq();
			try {
			moUssdReq = SendMoneyStateLogic.setLanguageState(arg0);
			
			System.out.println("moussd" + moUssdReq.getMessage());
			
				UssdRequestSender requestSender = new UssdRequestSender(new URL("http://127.0.0.1:7000/ussd/send"));
				requestSender.sendUssdRequest(moUssdReq);
			} catch (MalformedURLException | SdpException e) {
				
				e.printStackTrace();
			}
		}
		else{
			MtUssdReq moUssdReq = new MtUssdReq();
			
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
