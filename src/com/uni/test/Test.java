package com.uni.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://3.34.17.94:55939/mini", "mini1234", "mini1234");
			
			System.out.println("conn : " + conn);//성공하면 connection 값, 실패하면 null
			
			String sql = "show databases";
			
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String db = rset.getString("Database");
				System.out.println(db);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
