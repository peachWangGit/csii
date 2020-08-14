package com.csii.demo.start;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.dubbo.common.utils.ConfigUtils;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

public class TransStart {
	public static final String FILE_SEPARATOR = File.separator;
	public static final String PROPERTIES_SUFFIX = ".properties";
	public static final String LOGBACK = "logback.xml";
	public static final String CONF = "conf";
	public static final String DUBBO_APPLICATION_LOGGER = "dubbo.application.logger";
	public static final String LOG_BASE_DIR = "log.base.dir";
	public static final String LOG_FILE_NAME = "log.file.name";

	public static void main(String[] args) {
		System.out.println("***********Dubbo service starting **********");
		String userDir = null;
		if(args.length > 0){
			userDir = args[0];
		}else{
			userDir = System.getProperty("user.dir");

		}
		userDir = formatPath(userDir);
		System.out.println(String.format("user directory is [%s]", userDir));
		String dir = userDir.substring(0, userDir.lastIndexOf(FILE_SEPARATOR)) + FILE_SEPARATOR + CONF;
		loadProperties(dir);
		loadLogback(dir);
		String[] args2 = null;
		org.apache.dubbo.container.Main.main(args2);
	}

	private static void loadLogback(String dir) {
		if (dir != null) {
			String logbackPath = dir + FILE_SEPARATOR + LOGBACK;
			File logFile = new File(logbackPath);
			if (logFile.exists()) {
				LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(loggerContext);
				loggerContext.reset();
				try {
					configurator.doConfigure(logFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void loadProperties(String dir) {
		Properties properties = new Properties();
		loadProperties0(dir, properties);
		if (properties.containsKey(DUBBO_APPLICATION_LOGGER)) {
			System.setProperty(DUBBO_APPLICATION_LOGGER, properties.getProperty(DUBBO_APPLICATION_LOGGER));
		}
		if (properties.containsKey(LOG_BASE_DIR)) {
			System.setProperty(LOG_BASE_DIR, properties.getProperty(LOG_BASE_DIR));
		}
		if (properties.containsKey(LOG_FILE_NAME)) {
			System.setProperty(LOG_FILE_NAME, properties.getProperty(LOG_FILE_NAME));
		}
		ConfigUtils.addProperties(properties);
	}

	private static void loadProperties0(String dir, Properties properties) {
		if (dir != null && properties != null) {
			File dirFile = new File(dir);
			if (dirFile.isDirectory()) {
				File[] files = dirFile.listFiles();
				for (File file : files) {
					if (file.isFile()) {
						if (StringUtils.endsWithIgnoreCase(file.getName(), PROPERTIES_SUFFIX)) {
							try {
								properties.load(new FileInputStream(file));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else {
						loadProperties0(file.getAbsolutePath(), properties);
					}
				}
			}
		}
	}

	public static String formatPath(String path) {
		if (path != null) {
			path = StringUtils.replace(path, "\\\\", FILE_SEPARATOR);
			path = StringUtils.replace(path, "/", FILE_SEPARATOR);
			while (StringUtils.endsWithIgnoreCase(path, FILE_SEPARATOR)) {
				path = path.substring(0, path.length() - 1);
			}
		}
		return path;
	}
}
