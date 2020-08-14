package com.csii.demo.trans.service.transformer;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Map;

import com.csii.pe.core.Context;
import com.csii.pe.core.CoreControllerImpl;
import com.csii.pe.transform.Formatter;
import com.csii.pe.transform.TransformException;

public class CSHeadFormatter implements Formatter {

	public CSHeadFormatter() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public Object format(Object data, Map map) throws TransformException {

		Map<String, Object> dataMap = (Map<String, Object>) data;

		Context context = CoreControllerImpl.getContext();

		if (context != null) {

			if (context.getUser() != null) {

				dataMap.put("_MCHTimestamp", context.getTimestamp());
				dataMap.put("_MChannelId", "BBMS");
				dataMap.put("_MCHJnlNo", context.getData("_MCHJnlNo"));
				dataMap.put("_locale", context.getLocale());

			} else {
				dataMap.put("_MCHTimestamp", context.getTimestamp());
				dataMap.put("_MChannelId", "BBMS");
				dataMap.put("_MCHJnlNo", context.getData("_MCHJnlNo"));
				dataMap.put("_locale", context.getLocale());
			}

			// 2012/11/13 企业批量复合
			if (context.getData("_BatchEIBSAuth") != null) {
				dataMap.put("_MChannelId", context.getData("_MChannelId"));
			}
		} else {
			dataMap.put("_MCHTimestamp", new Timestamp(System.currentTimeMillis()));
			dataMap.put("_MChannelId", "BBMS");
			// 2012/11/13 企业批量复合
			if (dataMap.get("_BatchEIBSAuth") != null) {
				dataMap.put("_MChannelId", "EIBS");
			}
			// 批量程序在UNIX服务器上取的默认LOCALE为英文，上海银行只有中文 版导致取中文翻译文件取不到。20130118
			dataMap.put("_locale", Locale.SIMPLIFIED_CHINESE);

		}
		dataMap.put("_MCHJnlNo", "1111111");

		return dataMap;
	}

}
