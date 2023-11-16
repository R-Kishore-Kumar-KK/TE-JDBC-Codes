package com.te.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream("dbInfo.properties");
			
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			System.out.println(prop.getProperty("user"));
			System.out.println(prop.getProperty("password"));
			System.out.println(prop.getProperty("dbUrl"));
			System.out.println(prop.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
