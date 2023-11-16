package com.te.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			// step 1
			Class.forName("com.mysql.jdbc.Driver");

			// step 2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			connection = DriverManager.getConnection(dbUrl, "root", "root");

			// step3
			String query = "insert into interns values ('Paul',110,'1992-06-13','M','JFS',9874563789,98756,20,'O+','paul@gmail.com',500,70,'1999-08-13')";

			statement = connection.createStatement();

			int result = statement.executeUpdate(query);

			// step4
			System.out.println(result + " No of Records inserted");
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
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}

	}
}
