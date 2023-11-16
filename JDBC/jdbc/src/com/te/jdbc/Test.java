package com.te.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Test {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
//			Driver driver = new Driver();
//	        DriverManager.registerDriver(driver);
//			System.out.println("Driver Loaded");

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Driver Loaded");

			// step 2 get db connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate?user=root&password=root";

			connection = DriverManager.getConnection(dbUrl);

			// step 3 issue sql queries via connection
			String query = "Select * from interns";

			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(query); 

			// step 4 process the result
			int i = 1;
			while (resultSet.next()) {
				System.out.println("-------------" + i + "------------");
				System.out.println("Name   : " + resultSet.getString("name"));
				System.out.println("Id     : " + resultSet.getInt("id"));
				System.out.println("Dob    : " + resultSet.getDate("dob"));
				System.out.println("Gender : " + resultSet.getString("gender"));
				System.out.println("Role   : " + resultSet.getString("role"));
				System.out.println("Mobile : " + resultSet.getLong("mobile"));
				System.out.println("Salary : " + resultSet.getDouble("salary"));
				System.out.println("-------------" + i + "------------");
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
