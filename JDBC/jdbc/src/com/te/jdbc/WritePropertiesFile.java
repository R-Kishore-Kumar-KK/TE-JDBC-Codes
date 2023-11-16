package com.te.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WritePropertiesFile {

	public static void main(String[] args) {
		
		
		try {
			FileOutputStream outputStream = new FileOutputStream("dbInfo.properties");
			Properties prop = new Properties();
			
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			prop.setProperty("dbUrl", "jdbc:mysql://localhost:3306/technoelevate");
			prop.setProperty("driver", "com.mysql.jdbc.Driver");
			
			prop.store(outputStream, "Db information");
			System.out.println("Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
