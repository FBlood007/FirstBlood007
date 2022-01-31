package com.practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.sql.SQLException;

public class Example {
	Connection con;
	Statement s;
	PreparedStatement p;
	
	public Example() {
		con = DBconnection.getConnection();
	}
	public void fetchBookDetails()  {
//		s = con.createStatement();
//		ResultSet rs = s.executeQuery("select Bookid,BookName,Cost from book");
//		System.out.println("\tBookId\tBookName\t\tCost");
//		while(rs.next()) {
//			int id = rs.getInt(1);
//			String s = rs.getString(2);
//			int c = rs.getInt(3);
//			System.out.println("\t"+id+"\t"+s+"     \t"+c);
//		}
		
		//DONE WITH STATIC QUERY
		try(Statement s = con.createStatement();
				ResultSet rs = s.executeQuery("select Bookid,BookName,Cost from book");)
		{
			System.out.println("\tBookId\tBookName\tCost");
			while(rs.next()) {
				int id = rs.getInt(1);
				String s1 = rs.getString(2);
				int c = rs.getInt(3);
				System.out.println("\t"+id+"\t"+s1+"     \t"+c);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void saveBookDetails(int id1,String bname,int p) {
		//DONE WITH STATIC QUERY
		try(Statement s = con.createStatement();)
		{
			int rowsUpdated = s.executeUpdate("insert into book(BookId,BookName,Cost) "
					+ "values("+id1+",'"+bname+"','"+p+"')");
			
			System.out.println(rowsUpdated+" records saved succesfully!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public void deleteBookDetails(int id) {
		//DONE WITH STATIC QUERY
		try(Statement s = con.createStatement();)
		{
			int rowsUpdated= s.executeUpdate("delete from book where BookId="+id);
			System.out.println(rowsUpdated+" deleted successfully!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public void updateBookDetails() {
		try(Statement s = con.createStatement();)
		{
			int rowsUpdated= s.executeUpdate("update book set Cost=850 where BookId=25");
			System.out.println(rowsUpdated+" Updated successfully!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void saveBookData() {
		try(Statement s = con.createStatement();)
		{
			int rowsUpdated = s.executeUpdate("insert into book(BookId,BookName,Cost) "
					+ "values(100,'Java',1000)");
			
			System.out.println(rowsUpdated+" records saved successfully!");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
//	public void deleteBookDetailsPreparedS(int id) {
//		//DELETE Using PREPAREDSTATEMENT
//		String s = "delete from book where BookID=?";
//		try(PreparedStatement s1 =con.prepareStatement(s);)
//		{
//			s1.setInt(1,id);
//			int a =s1.executeUpdate();
//			System.out.println("Numbers of rows deleted are "+a);
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}	
//	}
//	public void updateBookDetailsPreparedS(int c ,int id) {
//		//UPDATE Using PREPAREDSTATEMENT
//		String s = "update book set Cost=? where BookId=?";
//		try(PreparedStatement s1 =con.prepareStatement(s);)
//		{
//			s1.setInt(1,c);
//			s1.setInt(2, id);
//			int a =s1.executeUpdate();
//			System.out.println("Numbers of rows updated are "+a);
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}	
//	}
//	public void insertBookDetailsPreparedS(int id,String BookName,int cost) {
//		//Insert Using PREPAREDSTATEMENT
//		String s = "insert into book (BookId,BookName,Cost) values (?,?,?)";
//		try(PreparedStatement s1 =con.prepareStatement(s);)
//		{
//			s1.setInt(1,id);
//			s1.setString(2, BookName);
//			s1.setInt(3, cost);
//			int a =s1.executeUpdate();
//			System.out.println("Numbers of rows updated are "+a);
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}	
//	}
//	public void selectBookDetailsPreparedS(int id) {
//		//select Using PREPAREDSTATEMENT
//		String s = "select BookId,BookName,Cost from book where BookId=?";
//		try(PreparedStatement s1 =con.prepareStatement(s);)
//		{
//			s1.setInt(1,id);
//			ResultSet r =s1.executeQuery();
//			System.out.println("\tBookId\tBookName\tCost");
//			while(r.next()) {
//				int i = r.getInt(1);
//				String ss = r.getString(2);
//				int c = r.getInt(3);
//				System.out.println("\t"+i+"\t"+ss+"     \t"+c);
//			}
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e.getMessage());
//		}	
//	}

	public static void main(String[] args)  {
		
		Example e = new Example();
		try {
		e.fetchBookDetails();
		//e.saveBookDetails(100, "Javaa", 500);//static query
		//e.fetchBookDetails();
		//e.deleteBookDetails(100);
		//e.saveBookData();//dynamic query
		//e.fetchBookDetails();
		//e.updateBookDetails();
		//e.deleteBookDetailsPreparedS(100);//PREPARED STATEMENT
		//e.updateBookDetailsPreparedS(600,100);//PREPARED STATEMENT UPDATE
		//e.fetchBookDetails();
		//e.insertBookDetailsPreparedS(150, "AAAA", 123);
		//e.selectBookDetailsPreparedS(100);

		e.con.close();
		}
		catch(SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
