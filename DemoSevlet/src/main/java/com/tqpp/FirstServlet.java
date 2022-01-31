package com.tqpp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/My")
public class FirstServlet extends HttpServlet {
	
	public FirstServlet() {
		System.out.println("In default constructor");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nm=request.getParameter("fname");
		String e=request.getParameter("email");
		
		PrintWriter out=response.getWriter();
		ServletContext ctx = getServletContext();
		String d=ctx.getInitParameter("url");
		ServletConfig cfg= getServletConfig();
		String user = cfg.getInitParameter("username");
//		out.println("Successful !!!");
//		out.print("<body><h1> Welcome user "+nm+"</h1");
////		out.print("<h4> Context "+d+"</h4>");
//		out.print("<h4> Name "+user+"</h4>");
//		out.print("<h4> Your email is "+e+"</h4>");
//		out.print("</body></html>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
