package com.te.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SelectDynamicQuery {

	public static void main(String[] args) {
		
		FileInputStream inputStream = null;
		Connection connection  = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			inputStream = new FileInputStream("dbInfo.properties");
			Properties prop = new Properties();
			prop.load(inputStream);
			
			//step 1
			Class.forName(prop.getProperty("driver"));
			
			//step 2
			connection = DriverManager.getConnection(prop.getProperty("dbUrl"), prop);
			
			//step 3
			String query = "select * from interns where id =?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(args[0]));
			
			resultSet = preparedStatement.executeQuery();
			
			//step 4
			if(resultSet.next()) {
				System.out.println("Name   : " + resultSet.getString("name"));
				System.out.println("Id     : " + resultSet.getInt("id"));
				System.out.println("Dob    : " + resultSet.getDate("dob"));
				System.out.println("Gender : " + resultSet.getString("gender"));
				System.out.println("Role   : " + resultSet.getString("role"));
				System.out.println("Mobile : " + resultSet.getLong("mobile"));
				System.out.println("Salary : " + resultSet.getDouble("salary"));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
				try {
					if(connection != null) {
					
					connection.close();
					}
					
					if(inputStream != null) {
						inputStream.close();
					}
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					
					e2.printStackTrace();
				}
			}
		}
	}

