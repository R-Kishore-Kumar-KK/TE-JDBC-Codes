package com.te.jdbcpractice;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectQueryDynamic {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement prs = null;
		ResultSet res = null;

		try {
			// step1
			Class.forName("com.mysql.jdbc.Driver");

			// step2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			con = DriverManager.getConnection(dbUrl, "root", "root");

			// step3
			String query = "select * from interns where id = ?";
			prs = con.prepareStatement(query);
			prs.setInt(1, Integer.parseInt(args[0]));
			res = prs.executeQuery();

			// step4
			if (res.next()) {
				System.out.println("Name: " + res.getString("name"));
				System.out.println("Id: " + res.getInt("id"));
				System.out.println("Date Of Birth: " + res.getString("dob"));
				System.out.println("Gender: " + res.getString("gender"));
				System.out.println("Mobile: " + res.getLong("mobile"));
				System.out.println("Salary: " + res.getDouble("salary"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

				if (prs != null) {
					prs.close();
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
