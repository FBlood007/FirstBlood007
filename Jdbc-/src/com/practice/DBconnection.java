package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/payroll?useSSL=false";
	public static final String USER = "root";
	public static final String PASS = "3qjspoyyppyypp";
	static Connection con = null;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
			System.out.println("Connected to database..");
			con = DriverManager.getConnection(JDBC_URL,USER,PASS);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		Connection con = DBconnection.getConnection();
		if(con!=null)
		{
			System.out.println("Connected to MY SQL Successfully");
		}
	}

}
