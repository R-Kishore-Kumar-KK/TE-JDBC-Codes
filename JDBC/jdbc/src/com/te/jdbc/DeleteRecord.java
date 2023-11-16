package com.te.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecord {

	public static void main(String[] args) {
		
		//Connection connection = null;
		//Statement statement = null;

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevate", "root", "root");
				Statement statement = connection.createStatement();){
			// step 1
			Class.forName("com.mysql.jdbc.Driver");

			// step 2
			//String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			//connection = DriverManager.getConnection(dbUrl, "root", "root");

			// step3
			String query = "delete from interns where email = 'prem@gmail.com'";

			//statement = connection.createStatement();

			int result = statement.executeUpdate(query);

			// step4
			System.out.println(result + " Deleted Successfull");
		} catch (Exception e) {
			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				
//				if(statement != null) {
//					statement.close();
//				}
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}

		}

	}
}
