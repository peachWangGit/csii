package com.csii.demo.trans.action;

import java.util.HashMap;
import java.util.Map;

import com.csii.demo.usr.bean.User;
import com.csii.demo.utils.ConfigUtil;
import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

@SuppressWarnings("all")
public class BankInnerTransferAction extends IbsQueryAction {

	@Override
	public void execute(Context context) throws PeException {
		Map result = new HashMap();
		try {
			log.info("context:" + context.getDataMap());
			Map map = context.getDataMap();
			
			map.put("_HostTransactionCode", "bankInnerTransfer");
			result = (Map) this.issueHostTrs(context, map);
			
			log.info("result:" + result);
			context.setData("json", result);
//			context.setDataMap(result);
		} catch (Exception e) {
			result.put("ReturnCode", e.getMessage());
			result.put("ReturnMessage", ConfigUtil.getProperty(e.getMessage(), "系统内部错误"));
			context.setDataMap(result);
		}
	}
}
