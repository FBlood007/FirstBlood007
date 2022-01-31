package com.TestQuestion;
/*1. To insert relevant data in Book table by accepting values from user.
  2. To display list of author name, book name , price with  costliest book at the top.
  3. Create ResultSet which see and update records from/to  Auther table. 
	1.See 10th record from result set.
	2.Display records in reverse order.
	3.Delete record from result set.
	4.Add record in result set .*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.practice.DBconnection;

public class WeekTest15Jan2022 {
	Connection con;
	Statement st,st1;
	ResultSet r,r1;
	
	public WeekTest15Jan2022() throws SQLException
	{
		con=DBconnection.getConnection();
		st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		r=st.executeQuery("select * from book");
		r1=st1.executeQuery("select * from author");
	}
	public void getDetails() throws SQLException {
		r.beforeFirst();
		System.out.println("----------------------------------------------------------------");
		System.out.println("BookId\tBookName\tAuthorId\tPrice");
		System.out.println("----------------------------------------------------------------");
		while(r.next()) {
			if(r.getString(2).length()<=5)
				System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t\t"+r.getInt(3)+"\t\t"+r.getFloat(4));
			else if(r.getString(2).length()>5)
				System.out.println(r.getInt(1)+"\t"+r.getString(2)+"\t"+r.getInt(3)+"\t\t"+r.getFloat(4));
		}
		System.out.println("----------------------------------------------------------------");
	}
	//1. To insert relevant data in Book table by accepting values from user.
	public void insertDataInBook(int bookid,String bookName,int aid,float price) throws SQLException {
		r.moveToInsertRow();
		r.updateInt(1, bookid);
		r.updateString(2, bookName);
		r.updateInt(3, aid);
		r.updateFloat(4, price);
		r.insertRow();
		System.out.println("\nNew Row Added");
	}
	// 2. To display list of author name, book name , price with  costliest book at the top.
	public void costlyBook() throws SQLException {
		Statement p = con.createStatement();
		r = p.executeQuery("select * from book order by price desc");
		System.out.println("AuthorName\tBookName\tPrice");
		while(r.next()) {
			r1.beforeFirst();
			String s = " ";
			while(r1.next()) {
				if(r.getInt(3)==r1.getInt(1)) {
					s=r1.getString(2);
					break;
				}
			}
			System.out.println(s+"\t\t"+r.getString(2)+"\t\t"+r.getInt(4));
		}

	}
	//1.See 10th record from result set.
	public void getFromAuthor(int i) throws SQLException {
		r1.absolute(i);
		System.out.println("Autid\tAutName\tMobile\t\tEmail\t\tAddress City");
		System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getString(3)+
				"\t"+r1.getString(4)+"\t"+r1.getString(5)+"\t"+r1.getString(6));
	}
	//2.Display records in reverse order.
	public void reverseOrder() throws SQLException {
		r1.afterLast();
		System.out.println("Autid\tAutName\tMobile\t\tEmail\t\tAddress City");
		while(r1.previous()) {
			System.out.println(r1.getInt(1)+"\t"+r1.getString(2)+"\t"+r1.getString(3)+
					"\t"+r1.getString(4)+"\t"+r1.getString(5)+"\t"+r1.getString(6));
		}
	}
	//3.Delete record from result set.
	public void deleteRecord(int recordNo) throws SQLException {
		r1.absolute(recordNo);
		r1.deleteRow();
		System.out.println("Row no. "+recordNo+" deleted");
	}
	//4.Add record in result set 
	public void addInAuthor(int id,String name,String mob,String email,String addre,String city) throws SQLException {
		r1.moveToInsertRow();
		r1.updateInt(1, id);
		r1.updateString(2, name);
		r1.updateString(3, mob);
		r1.updateString(4, email);
		r1.updateString(5, addre);
		r1.updateString(6, city);
		r1.insertRow();
		System.out.println("Row inserted");
	}
	public static void main(String[] args) throws SQLException {
		WeekTest15Jan2022 w = new WeekTest15Jan2022();
		//w.getDetails();
		//w.insertDataInBook(111, "Dell", 2, 700);
		//w.costlyBook();
		//w.getFromAuthor(10);
		//w.reverseOrder();
		//w.deleteRecord(5);
		//w.addInAuthor(11, "ABCD", "9123155122", "abcd@gmail.com", "pune", "Pune");
		
	}
}
