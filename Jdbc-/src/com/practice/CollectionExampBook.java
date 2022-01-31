package com.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class CollectionExampBook {
	Connection con;
	ResultSet rs,rs1;
	Statement s,s1;
	
	
	HashMap<Integer,Integer> countBooks ;
	HashMap<String,Integer> author ;
	
	public CollectionExampBook() throws SQLException {
		con= DBconnection.getConnection();
		s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		s1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		countBooks = new HashMap<>();
		author = new HashMap<>();
	}
	public void books() throws SQLException{//to get authorId and number of books written
		
		rs = s.executeQuery("select * from book");
		rs1 = s1.executeQuery("select * from author");
		int count=0;
		int id=0;
		while(rs1.next()) {
			rs.beforeFirst();
			while(rs.next()) {
				if(rs1.getInt(1)==rs.getInt(4)) {
					count++;
				}
			}
			id=rs1.getInt(1);
			countBooks.put(id, count);
			count=0;
		}
	}
	
	public void showCountBookMap(){
		
		Set<Entry<Integer,Integer>> s = countBooks.entrySet();
		for(Entry<Integer,Integer> e : s) {
			System.out.println(e.getKey()+"="+e.getValue());
		}
		
	}
	public void authorBookCount() throws SQLException{//to get author name and no of books written
		
		rs = s.executeQuery("select * from book");
		rs1 = s1.executeQuery("select * from author");
		int count=0;
		String name="";
		while(rs1.next()) {
			rs.beforeFirst();
			while(rs.next()) {
				if(rs1.getInt(1)==rs.getInt(4)) {
					count++;
				}
			}
			name=rs1.getString(2);
			author.put(name, count);
			count=0;
		}
	}
	public void showAuthorMap(){
		
		Set<Entry<String,Integer>> s = author.entrySet();
		for(Entry<String,Integer> e : s) {
			System.out.println(e.getKey()+"="+e.getValue());
		}
	}
	public static void main(String[] args) throws SQLException {
		CollectionExampBook c = new CollectionExampBook();
//		c.books();
		System.out.println();
		//c.showCountBookMap();
		System.out.println();
		c.authorBookCount();
		c.showAuthorMap();
		c.con.close();
	}
	
}
