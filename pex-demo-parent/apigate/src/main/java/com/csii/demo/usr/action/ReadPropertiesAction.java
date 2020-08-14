/*
 * @(#)ReadPropertiesAction.java	1.0 2018年4月9日 下午6:02:45
 *
 * Copyright 2004-2010 Client Server International, Inc. All rights reserved.
 * CSII PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.csii.demo.usr.action;


import java.util.ArrayList;
import java.util.List;

import com.csii.demo.utils.ConfigUtil;
import com.csii.ibs.action.IbsQueryAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

/**
 * {type specification, must edit}
 *
 * @author  TangJian {must edit, use true name}
 * <p>
 *   Created on 2018年4月9日
 *   Modification history	
 *   {add your history}
 * </p>
 * <p>
 *   IBS Product Expert Group, CSII
 *   Powered by CSII PowerEngine 6.0
 * </p>
 * @version 1.0
 * @since 1.0
 */
public class ReadPropertiesAction extends IbsQueryAction{

	@Override
	public void execute(Context context) throws PeException {
		// TODO 读取welcome.properties
		String welcome=ConfigUtil.getProperty("welcome");
		String host=ConfigUtil.getProperty("host");
		String zkhost=ConfigUtil.getProperty("zkhost");
		String dubbo=ConfigUtil.getProperty("dubbo.protocol.port");
		List<String> str= new ArrayList<>();
		str.add(welcome);
		str.add(host);
		str.add(zkhost);
		str.add(dubbo);
		//ResourceBundle bundel=ResourceBundle.getBundle("config");
		context.setData("json", str);
	}

}
