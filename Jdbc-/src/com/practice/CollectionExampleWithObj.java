package com.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Stream;
//HashMap<Author,ArrayList<Book>>
class Author{
	int authorID,publicationId;
	String authorName;
	public Author() {
	}
	public Author(int authorID,String authorName,int publicationId) {
		this.authorID=authorID;
		this.authorName=authorName;
		this.publicationId=publicationId;
	}
}
class Book{
	int bookId,cost,authorID;
	String BookName;
	public Book() {}
	public Book(int bookId, String bookName,int cost, int authorID) {
		this.bookId = bookId;
		this.BookName = bookName;
		this.cost = cost;
		this.authorID = authorID;
	}
}
public class CollectionExampleWithObj {
	Connection con;
	Statement s,s1;
	ResultSet r,r1;
	Author a;
 	Book b;
	HashMap<Author,ArrayList<Book>> details;
	
	public CollectionExampleWithObj() throws SQLException {
		con=DBconnection.getConnection();
		s=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		s1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		details = new HashMap<>();
	}
	
	public void getDetailsInMap() throws SQLException {
		r = s.executeQuery("select * from author");
		r1 = s1.executeQuery("select * from book");
		ArrayList<Book> b1;
		while(r.next()) {
			r1.beforeFirst();	
			b1 = new ArrayList<>();
			while(r1.next()) {
				if(r.getInt(1)==r1.getInt(4)){
					b=new Book(r1.getInt(1),r1.getString(2),r1.getInt(3),r1.getInt(4));
					b1.add(b);
				}
			}
			a = new Author(r.getInt(1),r.getString(2),r.getInt(3));
			details.put(a, b1);
		}
	}
	public void showMapDetails(){
		
		Set<Entry<Author,ArrayList<Book>>> s = details.entrySet();
		for(Entry<Author,ArrayList<Book>> e : s) {
			Author a =e.getKey();
			ArrayList<Book> a1 = e.getValue();
			System.out.println("Author = ["+a.authorID+","+a.authorName+","+a.publicationId+"]");
			Iterator<Book> i = a1.iterator();
			while(i.hasNext()) {
				Book b = i.next();
				System.out.println("\t"+"Book = ["+b.bookId+","+b.BookName+","+b.cost+","+ b.authorID+"]");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws SQLException {
		CollectionExampleWithObj c = new CollectionExampleWithObj();
		c.getDetailsInMap();
		System.out.println("\nAuthor with [AuthorID,AuthorName,PublicationID]");
		System.out.println("Book with [BookId,BookName,Cost,AuthorId]\n");
		c.showMapDetails();

	}

}
