package com.csii.demo.usr.action;

/*
 * @(#)JsonView.java	1.0 2004-10-18
 *
 * Copyright 2004 Client Server International, Inc. All rights reserved.
 * CSII PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ApplicationObjectSupport;

import com.csii.pe.channel.http.JsonUtils;
import com.csii.pe.channel.http.servlet.CsiiView;

/**
 * Comment
 * <p>
 * Created on 2004-10-18 
 * Modification history	
 * <p>
 * @author	PowerEngine Expert Group, CSII
 * @version	1.0
 * @since	1.0
 */

public class JsonView extends ApplicationObjectSupport implements CsiiView {
	protected Log log = LogFactory.getLog(this.getClass());
	
	public static final String HEADER_PRAGMA = "Pragma";
	public static final String HEADER_EXPIRES = "Expires";
	public static final String HEADER_CACHE_CONTROL = "Cache-Control";
	
	protected boolean nocacheFlag = true;
	protected String contentType = "application/json";
	protected String jsonField = "json";
	protected String encoding = "UTF-8";
	
	protected static final String JSON_ERROR = "jsonError";

	public void setNocacheFlag(boolean nocacheFlag) {
        this.nocacheFlag = nocacheFlag;
    }
    
	public void setJsonField(String cf) {
		this.jsonField = cf;
	}

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void render(
		String viewName,
		Object model,
		Locale locale,
		HttpServletRequest request,
		HttpServletResponse response
		) {
		
		preventCaching(response);
		response.setContentType(this.contentType);
		
		Object content;
		Map<String,Object> map = ((Map<String,Object>) model);
		if(map.containsKey(com.csii.pe.channel.http.Constants.DEFAULT_EXCEPTION_MSG_LIST_ATTRIBUTE)) {
		    content = map.get(com.csii.pe.channel.http.Constants.DEFAULT_EXCEPTION_MSG_LIST_ATTRIBUTE);
		    Map<String, Object> wrap = new HashMap<String, Object>(3);
		    wrap.put(JSON_ERROR, content);
		    content = wrap;
		}else if(map.get("_RejCode")!=null&&!"000000".equals(map.get("_RejCode"))){
		    content = map;
		} else if(viewName!=null && viewName.trim().length()>0)	{
			//content = map.get(viewName);
			viewName=viewName.trim();
			if(viewName.startsWith("[")&&viewName.endsWith("]")){
				viewName=viewName.substring(1,viewName.length()-1);
				String[] keys=viewName.split("\\|");
				Map result=new HashMap();
				for(String key:keys){
					String[] array=key.trim().split("\\$");
					key=array[0];
					if(array.length>1){
						Object value=map.get(key);
						if(value!=null){
							if(value instanceof List){
								List list=(List)value;
								List nameList=new ArrayList();
								for(Object obj:list){									
									nameList.add(getMessage(array[1], obj, locale));
								}
								result.put(key+"_Name", nameList);
							}else if(value.getClass().isArray()){
								String[] nameArray=new String[Array.getLength(value)];
								for(int i=0;i<Array.getLength(value);++i){
									nameArray[i]=getMessage(array[1],Array.get(value, i),locale);
								}
								result.put(key+"_Name", nameArray);
							}else{								
								result.put(key+"_Name", getMessage(array[1], map.get(key), locale));
							}
						}
						
					}					
					result.put(key, map.get(key));
				}
				content=result;
			}else{
				content = map.get(viewName);
			}
		} else if(jsonField!=null) {
			content = map.get(jsonField);
		}
		else
			content = model;
		
		//if(log.isDebugEnabled())	{
		//	log.debug("JsonView fetch model, key:" + viewName+" ,value:"+content);
		//}

		if (content == null)
			return;

		try {
			if("UTF-8".equalsIgnoreCase(encoding)) {
	            String json = JsonUtils.encode(content);
	            if(log.isTraceEnabled()) {
	                log.trace("json: " + json);
	            }
	            response.getWriter().write(json);
	            response.getWriter().flush();
			} else {
			    byte[] json = JsonUtils.encode(content, encoding);
			    if(log.isTraceEnabled()) {
                    log.trace("json bytes: " + new String(json,encoding));
                }
			    OutputStream out = response.getOutputStream();
    			response.setContentLength(json.length);
    			out.write(json);
    			out.flush();
			}
		} catch (Exception e) {
			log.error("render", e);
		}

	}
	
	private String getMessage(String name,Object value,Locale locale){
		if(value==null){
			return "";
		}
		return getApplicationContext().getMessage(name+"."+value,null,String.valueOf(value),locale);
	}

	protected final void preventCaching(HttpServletResponse response) {
	    // HTTP 1.0 header
		if(nocacheFlag)
			response.setHeader(HEADER_PRAGMA, "No-cache");
		response.setDateHeader(HEADER_EXPIRES, 1L);
		// HTTP 1.1 header
		if(nocacheFlag)
			response.setHeader(HEADER_CACHE_CONTROL, "no-cache");

	}	

}
