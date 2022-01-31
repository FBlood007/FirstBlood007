package com.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionExample {
	Connection con;
	ResultSet rs,rs1,rs2;
	Statement st,st1,st2;
	
	HashMap<Integer,Integer> emap;
	
	public CollectionExample() throws SQLException {
		con= DBconnection.getConnection();
		st = con.createStatement();
		emap= new HashMap<>();

	}
	
	public void createMap() throws SQLException {
		
		rs = st.executeQuery("Select * from employee");
		while(rs.next()) {
			emap.put(rs.getInt(1),rs.getInt(4));
		}
	}
	
	public void showRecordInMap()throws SQLException{
		Set<Entry<Integer,Integer>> s = emap.entrySet();
		for(Entry<Integer,Integer> s1 : s ) {
			System.out.println("Value = "+s1.getKey()+ ", Key = "+s1.getValue());
		}
	}
	public static void main(String[] args) throws SQLException {
		CollectionExample c = new CollectionExample();
		c.createMap();
		c.showRecordInMap();

		c.con.close();
	}

}
