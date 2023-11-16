package com.te.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateQueryDynamic {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement prs = null;
		
		try {
			//step1
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			con = DriverManager.getConnection(dbUrl, "root", "root");
			
			//step3
			String query = "update interns set salary = ? , blood_group = ? where id = ?";
			prs = con.prepareStatement(query);
			
			prs.setDouble(1, Double.parseDouble(args[0]));
			prs.setString(2, args[1]);
			prs.setInt(3, Integer.parseInt(args[2]));
			
			//step4
			int res = prs.executeUpdate();
			System.out.println(res+ "No of rows Affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				
				if(prs != null) {
					prs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
