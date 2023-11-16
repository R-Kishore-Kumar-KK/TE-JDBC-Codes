package com.te.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteQueryStatic {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			// step1
			Class.forName("com.mysql.jdbc.Driver");

			// step2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			con = DriverManager.getConnection(dbUrl, "root", "root");
			stmt = con.createStatement();

			// step3
			String query = "delete from interns where id = 111";
			int res = stmt.executeUpdate(query);

			// step4
			System.out.println(res + " No of rows deleted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
