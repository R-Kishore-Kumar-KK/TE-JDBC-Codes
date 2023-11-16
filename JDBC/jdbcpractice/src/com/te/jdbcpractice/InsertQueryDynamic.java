package com.te.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertQueryDynamic {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement prs = null;
		
		try {
			//step1
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2
			String dbUrl = "jdbc:mysql://localhost:3306/technoelevate";
			con = DriverManager.getConnection(dbUrl, "root","root");
			
			//step3
			String query = "insert into interns values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			prs = con.prepareStatement(query);
			
			prs.setString(1, args[0]);
			prs.setInt(2, Integer.parseInt(args[1]));
			prs.setString(3, args[2]);
			prs.setString(4, args[3]);
			prs.setString(5, args[4]);
			prs.setLong(6, Long.parseLong(args[5]));
			prs.setDouble(7, Double.parseDouble(args[6]));
			prs.setInt(8, Integer.parseInt(args[7]));
			prs.setString(9, args[8]);
			prs.setString(10, args[9]);
			prs.setInt(11, Integer.parseInt(args[10]));
			prs.setInt(12, Integer.parseInt(args[11]));
			prs.setString(13, args[12]);
			
			int res = prs.executeUpdate();
			
			//step4
			System.out.println(res+" No of rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				
				if(prs!= null) {
					prs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
