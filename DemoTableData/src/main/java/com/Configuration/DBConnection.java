package com.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	      
		  private static final String URL="jdbc:mysql://localhost:3306/advancejava";
		  private static final String USERNAME="root";
		  private static final String PASSWORD="3qjspoyyppyypp";
		  
		  public static Connection getConnection()
		  {
			  
			  Connection con=null;
			  try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			  return con;
			  
			  
		  }
		  
	}