package com.ebbyware.tasklist.config;

import java.io.IOException;
import java.util.Properties;

public class PropertiesValues<T> {
	Class<T> klass;
	String propPath; 
	Properties props;
	
	public PropertiesValues(Class<T> klass, String path) {
		this.klass = klass;
		this.propPath = path;
		loadProperties();
	}
	
	public String getProperty(String key) {
		return props.getProperty(key, "");
	}
	
	void loadProperties() {
		props = new Properties();
		try {
		    //load a properties file from class path, inside static method
			props.load(klass.getClassLoader().getResourceAsStream(propPath));

//		    //get the property value and print it out
//		    System.out.println(props.getProperty("database"));
//		    System.out.println(props.getProperty("dbuser"));
//		    System.out.println(props.getProperty("dbpassword"));

		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
	}
}
