package com.lee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DBConnection {
 
	private static String id ="hr";
	private static String pwd ="1234"; 
	private static String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	static Connection getConnection() throws ClassNotFoundException, SQLException  {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		return con;
	}
	
	static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		rs.close();
		pstmt.close();
		con.close();
		
	}

	static void close(PreparedStatement pstmt, Connection con) throws SQLException {
		pstmt.close();
		con.close();
		
	}
}
