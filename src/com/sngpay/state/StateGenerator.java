package com.sngpay.state;

import java.lang.reflect.Constructor;

import com.sngpay.exception.ErrorType;
import com.sngpay.exception.StateCreationException;

public class StateGenerator {

	public static State createStateInstance(String stateType ) throws StateCreationException {
		try{
			String stateName = stateType;
			Class<?> clazz = Class.forName("com.sngpay.state."+stateName);
			Constructor<?> ctor = clazz.getConstructor(String.class);
			Object object = ctor.newInstance(new Object[] { stateType });
			return (State)object;
		}catch(Exception e){
			throw new StateCreationException("State Creation Failed:" + stateType, ErrorType.STATE_CREATE_FAIL);
		}
		
	}
}
