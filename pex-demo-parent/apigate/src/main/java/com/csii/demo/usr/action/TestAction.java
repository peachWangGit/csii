package com.csii.demo.usr.action;

import java.util.Map;

import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class TestAction extends IbsQueryAction {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Context context) throws PeException {
		Map map = context.getDataMap();
		
		map.put("_HostTransactionCode", "test2");
		
		Map result = (Map) this.issueHostTrs(context, map);
		
		context.setData("json", result);
	}
}
