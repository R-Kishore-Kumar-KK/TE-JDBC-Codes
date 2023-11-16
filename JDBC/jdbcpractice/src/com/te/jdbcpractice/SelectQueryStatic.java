package com.te.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQueryStatic {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			// step1
			Class.forName("com.mysql.jdbc.Driver");

			// step2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevate", "root", "root");

			stmt = con.createStatement();

			// step3
			res = stmt.executeQuery("select * from interns");

			// step4
			while (res.next()) {
				System.out.println("---------------------------");
				System.out.println("Name: "+res.getString("name"));
				System.out.println("Id: "+res.getInt("id"));
				System.out.println("Date Of Bith: "+res.getString("dob"));
				System.out.println("Mobile: "+res.getLong("mobile"));
				System.out.println("---------------------------");
			}

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

				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
