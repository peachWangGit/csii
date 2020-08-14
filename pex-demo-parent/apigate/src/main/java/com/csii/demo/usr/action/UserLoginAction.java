package com.csii.demo.usr.action;

import java.util.Map;

import com.csii.demo.usr.bean.User;
import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.channel.http.LocalServletContext;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;
import com.csii.pe.validation.ValidationException;

public class UserLoginAction extends IbsQueryAction {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Context context) throws PeException {
		Map map = context.getDataMap();
		
		map.put("_HostTransactionCode", "login");
		
		Map result = (Map) this.issueHostTrs(context, map);
		
		LocalServletContext lsc = (LocalServletContext) context;
		
		User user = (User) result.get("User");
		if(user != null){
			lsc.setSessionAttribute("_USER_", user);
			String sessionid = lsc.getSessionId();
			log.info("Seesionid=" + sessionid);
			context.setData("json", result);
//			context.setDataMap(result);
		}else{
			throw new ValidationException("role.invalid_user");
		}
		
	}
}
