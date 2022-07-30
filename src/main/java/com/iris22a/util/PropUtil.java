package com.iris22a.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropUtil {
	private static final Logger log = Logger.getLogger(PropUtil.class);
	
	public String getValue(String filePath, String key) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filePath);//reading file
		} catch (FileNotFoundException e) {
			//System.out.println("File not found: "+filePath);
			log.info("File not found: "+filePath);
		}
		Properties prop = new Properties();//object of propertis class 
		try {
			prop.load(fis);//load propertis file
		} catch (IOException e) {
			//System.out.println("Unable to load propertis file: "+filePath);
			log.info("Unable to load propertis file: "+filePath);
		}
		//prop.get(key);//this method returns object 
		return prop.getProperty(key);//read property file
	}
	
	/**
	 * This method can be used on OR.properties file only.
	 * @param key for which we want the locator
	 * @return the locator value in the form of{@code String}
	 */
	
	public String[] getLocator(String key) {
		String baseDir = System.getProperty("user.dir");//currect working directory
		return getValue(baseDir+"/src/main/resources/OR.properties", key).split("##");

	}

}
