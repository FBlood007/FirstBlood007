package com.tqpp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		if(user.equals("Raj")&&password.equals("root"))
		{
//			RequestDispatcher rd = request.getRequestDispatcher("addstud");
//			rd.forward(request, response);
			ArrayList<Student1> ar = new ArrayList<>();
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","3qjspoyyppyypp");
			
				Statement pst = con.createStatement();
				ResultSet rs = pst.executeQuery("select * from student");
				while(rs.next()) {
					Student1 s = new Student1();
					s.setSid(rs.getInt(1));
					s.setSname(rs.getString(2));
					s.setPercent(rs.getInt(3));
					//s.setBirthdate(rs.getDate(4));
					s.setCity(rs.getString(5));
					ar.add(s);	
				}
				
				request.setAttribute("stu", ar);
				RequestDispatcher rd= request.getRequestDispatcher("Add.jsp");
				rd.forward(request, response);
				
			}catch(SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("Invalid User !");
			out.print("Re-enter the data");
			RequestDispatcher rd1 = request.getRequestDispatcher("Success.jsp");
			rd1.include(request, response);	
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
