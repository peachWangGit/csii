package com.csii.pe.json.view;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ApplicationObjectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csii.demo.utils.ConfigUtil;
import com.csii.pe.channel.http.servlet.CsiiView;

public class DefaultExceptionJsonView extends ApplicationObjectSupport implements CsiiView {
	protected boolean nocacheFlag = true;
	
	protected String contentType;
	
	public boolean isNocacheFlag() {
		return nocacheFlag;
	}

	public void setNocacheFlag(boolean nocacheFlag) {
		this.nocacheFlag = nocacheFlag;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void render(String paramString, Object model, Locale local,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			preventCaching(response);
			response.setContentType(this.contentType);
			Map map = (Map)model;
			String ReturnCode = (String) map.get("_exceptionMessageCode");
			if(ReturnCode == null || ReturnCode.trim().equals("")){
				ReturnCode = "service.invalid";
			}
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("ReturnCode", ReturnCode);
			jsonObj.put("ReturnMessage", ConfigUtil.getProperty(ReturnCode));
			byte[] json = JSON.toJSONBytes(jsonObj, new SerializerFeature[]{});
			response.setContentLength(json.length);
			ServletOutputStream out = response.getOutputStream();
			out.write(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected final void preventCaching(HttpServletResponse response) {
		if (this.nocacheFlag) {
			response.setHeader("Pragma", "No-cache");

			response.setHeader("Cache-Control", "no-cache");
		}
		response.setDateHeader("Expires", 1L);
	}
}
