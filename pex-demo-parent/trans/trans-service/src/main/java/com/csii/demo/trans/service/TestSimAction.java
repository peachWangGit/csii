package com.csii.demo.trans.service;

import java.util.HashMap;
import java.util.Map;

import com.csii.pe.action.AbstractExecutableAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;
import com.csii.pe.service.comm.CommunicationException;
import com.csii.pe.service.comm.Transport;

public class TestSimAction extends AbstractExecutableAction {
	
	private static Transport transport;
	
	@SuppressWarnings("unused")
	@Override
	public void execute(Context context) throws PeException {
		Integer id = context.getInteger("Id");
		String testParam = context.getString("TestParam");
		
		System.out.println(id);
		System.out.println(testParam);
		
		Map param = context.getDataMap();
		param.put("_HostTransactionCode", "TestSim");
		Map<String, Object> retMap = (Map<String, Object>)transport.submit(param);
		
		context.setData("ResultParam", retMap.get("ResultParam"));
	}
	
	public static Transport getTransport() {
		return transport;
	}

	public static void setTransport(Transport transport) {
		TestSimAction.transport = transport;
	}
	
	
}
