package com.util;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static String username="root";
	private static String password="";
	private static String connectionURL="jdbc:mysql://localhost:3306/test";
	private static String driverClass="com.mysql.jdbc.Driver";
	
	public static Connection getDBConnection()
	{
		Connection conn=null;
		try {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(connectionURL,username,password);
			if(conn!=null)
			{
				System.out.println("Your Are Connected");
			}
			else
			{
				System.out.println("Your Are Not Connected");
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
			
		}
		return conn;
	}
	public static void main(String[] args) {
		DBConnection.getDBConnection();
	}
}
