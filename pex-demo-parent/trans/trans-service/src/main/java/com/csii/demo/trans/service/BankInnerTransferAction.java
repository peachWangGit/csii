package com.csii.demo.trans.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csii.demo.trans.bean.JTFBankInner;
import com.csii.demo.trans.dao.inter.TransDao;
import com.csii.demo.trans.dao.mapper.TransMapper;
import com.csii.demo.utils.IdUtil;
import com.csii.pe.action.AbstractExecutableAction;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;
import com.csii.pe.service.comm.CommunicationException;
import com.csii.pe.service.comm.Transport;

public class BankInnerTransferAction extends AbstractExecutableAction {
	private static Logger logger = LoggerFactory.getLogger(BankInnerTransferAction.class);	


	private static Transport transport;
	@Autowired
	private TransMapper transmapper;
	



	@SuppressWarnings("unused")
	@Override
	public void execute(Context context) throws PeException {
		logger.debug("context:" + context);
		JTFBankInner jTFBankInner = new JTFBankInner();
		jTFBankInner.setJnlNo((String) context.getData("JnlNo"));
		jTFBankInner.setAmount(((String) context.getData("Amount")));
		int flag = transmapper.insertJtfBankInner(jTFBankInner);
		this.callSim(context);
		context.setData("Success", true);
		if(flag>0) {
			context.setData("Success", true);
		}else {
			context.setData("Defeat", true);
		}

	}

	@SuppressWarnings("static-access")
	private void callSim(Context context) throws CommunicationException {
		String jnlNo = (String) context.getData("JnlNo");
		String amount = (String) context.getData("Amount");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("JnlNo", jnlNo);
		param.put("Amount", amount);
		param.put("_HostTransactionCode", "trSimHello");
		@SuppressWarnings("unchecked")
		Map<String, Object> retMap = (Map<String, Object>) this.transport.submit(param);
		// 后台返回结果
		String simResult = "" + retMap.get("result");
		logger.info("#### simResult:" + simResult);
	}

	@SuppressWarnings({ "unchecked", "unused", "resource" })
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(BankInnerTransferAction.class);
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/pe/*.xml" });
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 1);
		param.put("name", 1);
		param.put("_HostTransactionCode", "trSimHello");
		Map<String, Object> retMap = null;
		try {
			retMap = (Map<String, Object>) getTransport().submit(param);
		} catch (CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 后台返回结果
		String simResult = "" + retMap.get("result");
		logger.info("#### simResult:" + simResult);
	}


	
	public void setTransmapper(TransMapper transmapper) {
		this.transmapper = transmapper;
	}


	public static Transport getTransport() {
		return transport;
	}

	public static void setTransport(Transport transport) {
		BankInnerTransferAction.transport = transport;
	}

//	public JTFBankInner getjTFBankInner() {
//		return jTFBankInner;
//	}
//
//	public void setjTFBankInner(JTFBankInner jTFBankInner) {
//		this.jTFBankInner = jTFBankInner;
//	}

}
