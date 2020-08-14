package com.csii.demo.trans.action;

import java.util.Map;

import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class TestSimAction extends IbsQueryAction {
	
	@Override
	public void execute(Context context) throws PeException {
		Map map = context.getDataMap();
		map.put("_HostTransactionCode", "testSim");
		Map result = (Map) this.issueHostTrs(context, map);
		
		context.setData("json", result);
	}
	
}
