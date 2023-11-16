package com.te.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteQueryDynamic {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement prs = null;

		try {
			// step1
			Class.forName("com.mysql.jdbc.Driver");

			// step2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			con = DriverManager.getConnection(dbUrl, "root","root");

			// step3
			String query = "delete from interns where id = ?";
			prs = con.prepareStatement(query);

			prs.setInt(1, Integer.parseInt(args[0]));

			int res = prs.executeUpdate();

			// step4
			System.out.println(res + " No of rows affected");
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
