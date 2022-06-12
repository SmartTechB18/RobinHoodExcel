package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
	
	public static String getCofig(String key) throws IOException {
		
		Properties pr = new Properties();
		String path = "C:\\Users\\Urmi\\eclipse-workspaceUrmi\\BizBeeSelenium\\config.Properties";
		
		FileInputStream fis = new FileInputStream(path);
		
		pr.load(fis);
		return pr.get(key).toString();
	}


}
