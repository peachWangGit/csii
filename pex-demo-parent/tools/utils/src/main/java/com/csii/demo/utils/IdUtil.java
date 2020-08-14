package com.csii.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csii.demo.utils.id.IdWorker;

public class IdUtil {
	protected static final Logger LOG = LoggerFactory.getLogger(IdUtil.class);
	private static IdWorker idWorker = null;
	static {
		init();
	}
	public static void init(){
		String ifp_workerId =  ConfigUtil.getProperty("sns.workerId");
		if(ConfigUtil.isEmpty(ifp_workerId)){
			ifp_workerId = System.getProperty("sns.workerId");
		}
		if(ConfigUtil.isEmpty(ifp_workerId)){
			throw new NullPointerException("sns.workerId can't be null");
		}
		long workerId = Long.valueOf(ifp_workerId);
		if(idWorker == null){
			idWorker = new IdWorker(workerId);
		}
		LOG.debug("Id Genrator initialization done! worker id is [{}]",workerId);
	}
	
	public static long nextId(){
		if(idWorker == null){
			init();
		}
		return idWorker.nextId();
	}
	public static String nextStringId(){
		return String.valueOf(nextId());
	}
}
