package com.csii.pe.samples.springcloud.gateway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.csii.pe.action.Action;
import com.csii.pe.action.Executable;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class GateWayAction implements Action, Executable {
	@Autowired
	RestTransport restTransport;
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(Context context) throws PeException {
		Map<Object,Object> request=new HashMap<>();
		request.putAll(context.getDataMap());
		request.put("_TransactionId", context.getTransactionId());
		request.put("_ServiceName", "PE-SPRING-CLOUD-DEMO");
		Map<?, ?> response=(Map<?, ?>) restTransport.submit(request);
		context.setDataMap(response);
	}

}
