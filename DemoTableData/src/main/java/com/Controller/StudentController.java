package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.StudentDao;
import com.Dao.StudentDaoImplimentation;
import com.Model.Student;

@WebServlet("/")
public class StudentController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(request.getServletPath());

		String operation = request.getServletPath();

		PrintWriter out = resp.getWriter();
		StudentDao sdao = new StudentDaoImplimentation();

		switch (operation) {
		case "/delete":	int sid=Integer.parseInt(request.getParameter("id"));
						sdao.deleteStudentById(sid);
						resp.sendRedirect("a");
						break;
						
		case "/edit": 	sid=Integer.parseInt(request.getParameter("id"));
						Student ob=sdao.getStudentById(sid);
						request.setAttribute("sobj", ob);
						RequestDispatcher rdd=request.getRequestDispatcher("edit.jsp");
						rdd.forward(request, resp);
						break;
						
		case "/save":   sid=Integer.parseInt(request.getParameter("sid"));
						String nm=request.getParameter("sname");
						int percent=Integer.parseInt(request.getParameter("percent"));
						String city=request.getParameter("city");
						Student s1=new Student(sid, nm, percent, city);
						sdao.updateStudent(s1);
						resp.sendRedirect("a");
						break;
		

		default:	List<Student> slist = sdao.getAllStudents();
					request.setAttribute("studlist", slist);
					RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
					rd.forward(request, resp);

		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
