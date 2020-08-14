package com.csii.demo.sim.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.csii.pe.action.Action;
import com.csii.pe.action.Executable;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class HelloSimAction implements Action, Executable {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public void execute(Context context) throws PeException {
		String jnlNo = (String) context.getData("JnlNo");
		String amount = (String) context.getData("Amount");
		
		log.info("#### data input JnlNo: " + jnlNo);
		log.info("#### data input Amount: " + amount);
		
		context.setData("result", "trSimHello result");
		log.info("####  data output result:" + "trSimHello result");
		
		context.setData("_ResponseRejCode", "000000");
	}

}
