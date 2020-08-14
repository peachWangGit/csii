package com.csii.demo.query.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csii.demo.trans.dao.inter.TransDao;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class TestAction extends BaseQueryAction {
	private TransDao transDao;
	private static Logger logger = LoggerFactory.getLogger(TestAction.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Context context) throws PeException {
		String t=(String)context.getData("TestRequest");
		logger.debug("=======testRequest=========="+t);
		Map map=new HashMap();
		map.put("TestResponse", "test");
		context.setDataMap(map);
		logger.debug("=======TestAction Ok==========");
	}

	public TransDao getTransDao() {
		return transDao;
	}

	public void setTransDao(TransDao transDao) {
		this.transDao = transDao;
	}

}
