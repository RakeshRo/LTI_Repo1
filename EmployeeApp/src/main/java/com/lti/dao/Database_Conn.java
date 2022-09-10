package com.lti.dao;
import java.sql.*;
public class Database_Conn {
	public static Connection getConn() throws SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn=DriverManager.getConnection(url,"SYSTEM","Rakesh@733");
		if(conn!=null) {
			System.out.println("Connected");			
			//return conn;	
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException{
			
	}
}
