import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cook1")
public class DemoCookie1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie ck=new Cookie("name","Rajdeep");
		//ck.setMaxAge(60*60);
		PrintWriter out=resp.getWriter();
		out.print("<html><body>");
		out.print("<h1> Welcome user to cookie</h1>");
		out.print("<a href='cook2'>Cookie Next</a>");
		resp.addCookie(ck);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
