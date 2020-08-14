package com.csii.demo.utils.properties;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.csii.demo.utils.ConfigUtil;

public class Configer extends PropertyPlaceholderConfigurer {

	@Override
	protected Properties mergeProperties() throws IOException {
		Properties properties = super.mergeProperties();
		ConfigUtil.appendProperties(properties);
		return properties;
	}

}
