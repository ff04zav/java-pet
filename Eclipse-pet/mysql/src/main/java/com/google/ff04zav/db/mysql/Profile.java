package com.google.ff04zav.db.mysql;

import java.io.IOException;
import java.util.Properties;

public class Profile {
	public static Properties getProperties(String name) throws RuntimeException {
		Properties props = new Properties();
    	String env = System.getProperty("env");
    	if (env == null) {
    		env = "dev";
    	}
    	String propertiesFile = String.format("/config/%s.%s.properties", name, env);
    	try {
    		var inStream = App.class.getResourceAsStream(propertiesFile);
    		if (inStream  != null) {
    			props.load(inStream);
    		} else {
    			throw new RuntimeException("Cannot load properties file " + propertiesFile);
    		}
		} catch (IOException e1) {
			throw new RuntimeException("Cannot load properties file " + propertiesFile);
		}
		return props;
	}
}
