package com.sngpay.state;

import java.lang.reflect.Constructor;

public class StateGenerator {

	public static State createStateInstance(String stateType ) throws Exception{
		
		String stateName = stateType;
		Class<?> clazz = Class.forName("com.sngpay.state."+stateName);
		Constructor<?> ctor = clazz.getConstructor(String.class);
		Object object = ctor.newInstance(new Object[] { stateType });
		return (State)object;
		
	}
}
