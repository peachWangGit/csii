package com.csii.demo.query.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csii.demo.trans.bean.JTFBankInner;
import com.csii.demo.trans.dao.inter.TransDao;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class QueryJnlServiceImpl extends BaseQueryAction {
	private TransDao transDao;
	private static Logger logger = LoggerFactory.getLogger(QueryJnlServiceImpl.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Context context) throws PeException {
		String userid  = (String)context.getData("UserId");
		logger.debug("userid=="+userid);
		List<JTFBankInner> list = transDao.queryJTFBankInner(userid);
		Map map=new HashMap();
		map.put("List", list);
		context.setDataMap(map);
	}

	public TransDao getTransDao() {
		return transDao;
	}

	public void setTransDao(TransDao transDao) {
		this.transDao = transDao;
	}

}
