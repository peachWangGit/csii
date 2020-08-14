package com.csii.demo.trans.action;

import java.util.HashMap;
import java.util.Map;

import com.csii.demo.utils.ConfigUtil;
import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

@SuppressWarnings("all")
public class TestAction extends IbsQueryAction {

	@Override
	public void execute(Context context) throws PeException {
		Map result = new HashMap();
		try {
			Map map = context.getDataMap();
			log.debug("context:" + context.getDataMap());
			map.put("_HostTransactionCode", "test");
			
			result = (Map) this.issueHostTrs(context, map);
			log.debug("result:" + result);

			context.setDataMap(result);
			context.setData("json", result);
		} catch (Exception e) {
			result.put("ReturnCode", e.getMessage());
			result.put("ReturnMessage", ConfigUtil.getProperty(e.getMessage(), "系统内部错误"));
			context.setDataMap(result);
		}
	}
}
