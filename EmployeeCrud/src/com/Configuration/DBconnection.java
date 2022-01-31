package com.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	public static final String JDBC_DRIVER= "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/advancejava?useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "3qjspoyyppyypp";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = getConnection();
		if(con==null) {
			System.out.println("Connected to MY SQL Successfully");
		}
	}

}
