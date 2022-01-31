package com.practice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PreparedStatements {
	Connection con;
	Statement s;
	PreparedStatement p;
	
	public PreparedStatements() {
		con = DBconnection.getConnection();
	}
	public void deleteBookDetailsPreparedS(int id) {
		//DELETE Using PREPAREDSTATEMENT
		String s = "delete from book where BookID=?";
		try(PreparedStatement s1 =con.prepareStatement(s);)
		{
			s1.setInt(1,id);
			int a =s1.executeUpdate();
			System.out.println("Numbers of rows deleted are "+a);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public void updateBookDetailsPreparedS(int c ,int id) {
		//UPDATE Using PREPAREDSTATEMENT
		String s = "update book set Cost=? where BookId=?";
		try(PreparedStatement s1 =con.prepareStatement(s);)
		{
			s1.setInt(1,c);
			s1.setInt(2, id);
			int a =s1.executeUpdate();
			System.out.println("Numbers of rows updated are "+a);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public void insertBookDetailsPreparedS(int id,String BookName,int cost) {
		//Insert Using PREPAREDSTATEMENT
		String s = "insert into book (BookId,BookName,Cost) values (?,?,?)";
		try(PreparedStatement s1 =con.prepareStatement(s);)
		{
			s1.setInt(1,id);
			s1.setString(2, BookName);
			s1.setInt(3, cost);
			int a =s1.executeUpdate();
			System.out.println("Numbers of rows updated are "+a);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public void selectBookDetailsPreparedS(int id) {
		//select Using PREPAREDSTATEMENT
		String s ="select BookId,BookName,Cost from book where BookId=?";
		try(PreparedStatement s1 =con.prepareStatement(s);)
		{
			s1.setInt(1,id);
			ResultSet r =s1.executeQuery();
			System.out.println("\tBookId\tBookName\tCost");
			while(r.next()) {
				int i = r.getInt(1);
				String ss = r.getString(2);
				int c = r.getInt(3);
				System.out.println("\t"+i+"\t"+ss+"     \t"+c);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	public static void main(String[] args) throws SQLException {
		PreparedStatements p = new PreparedStatements();
		p.selectBookDetailsPreparedS(1);
//		p.insertBookDetailsPreparedS(5000, "AAA", 500);
//		p.updateBookDetailsPreparedS(600, 5000);
//		p.deleteBookDetailsPreparedS(5000);
		p.con.close();
		
	}
}