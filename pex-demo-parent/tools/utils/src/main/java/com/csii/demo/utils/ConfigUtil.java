package com.csii.demo.utils;

import java.util.Properties;

public class ConfigUtil {

	private static final Properties PROPERTIES = new Properties();

	public static void appendProperties(Properties properties) {

		if (properties == null) {
			throw new IllegalArgumentException("properties must not null");
		}
		PROPERTIES.putAll(properties);
	}
	public static void setProperty(String key, Object value){
		PROPERTIES.put(key, value);
	}
	public static String getProperty(String key) {
		Object value = PROPERTIES.get(key);
		return isEmpty(value) ? null : value.toString();
	}

	public static boolean isEmpty(Object value) {
		return value == null || value.toString().trim().length() == 0;
	}

	public static int getProperty(String key, int defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return Integer.parseInt(value);
	}

	public static short getProperty(String key, short defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return Short.parseShort(value);
	}

	public static long getProperty(String key, long defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return Long.parseLong(value);
	}

	public static String getProperty(String key, String defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return value;
	}

	public static float getProperty(String key, float defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return Float.parseFloat(value);
	}

	public static double getProperty(String key, double defaultValue) {
		String value = getProperty(key);
		if (isEmpty(value)) {
			return defaultValue;
		}
		return Double.parseDouble(value);
	}
}
