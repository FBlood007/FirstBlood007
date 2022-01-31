package com.tqpp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addstud")
public class AddStudent extends HttpServlet{
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nm=req.getParameter("snm");
		int percent=Integer.parseInt(req.getParameter("percent"));
		String city=req.getParameter("city");
		
		req.setAttribute("snm", nm);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","3qjspoyyppyypp")){
			PreparedStatement pst = con.prepareStatement("insert into student(sname,percent,city) values (?,?,?)");
			pst.setString(1, nm);
			pst.setInt(2,percent);
			pst.setString(3, city);
			pst.executeUpdate();
			req.setAttribute("status", "Successful");
			RequestDispatcher rd=req.getRequestDispatcher("Success.jsp");
			rd.forward(req, resp);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
//		
//		PrintWriter out = resp.getWriter();
//		out.print("<html>");
//		out.print("<body><h1>welcome user "+nm+"</h1>");
//		out.print("<h4> Percent = " +percent+" </h4>");
//		out.print("<h4> City = " +city+" </h4>");
//		out.print("</body></html>");
		
//		RequestDispatcher rd= req.getRequestDispatcher("Add.jsp");
//		rd.forward(req, resp);

			
		
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}


	
