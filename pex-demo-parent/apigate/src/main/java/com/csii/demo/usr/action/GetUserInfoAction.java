package com.csii.demo.usr.action;

import com.csii.demo.usr.bean.User;
import com.csii.demo.utils.ConfigUtil;
import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class GetUserInfoAction extends IbsQueryAction {

	@Override
	public void execute(Context context) throws PeException {
		User user=(User)context.getSessionAttribute("_USER_");
		if(user != null){			
			context.setData("User", user);
		}else{
			context.setData("ReturnCode", "sys.innner.error");
			context.setData("ReturnMessage", ConfigUtil.getProperty("sys.innner.error", "系统内部错误"));
		}
		context.setData("Welcome", ConfigUtil.getProperty("welcome"));
	}
}
