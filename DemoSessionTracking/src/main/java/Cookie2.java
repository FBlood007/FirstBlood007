

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cook2")
public class Cookie2 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck1=new Cookie("Percent","99.99");
		PrintWriter out=response.getWriter();
		out.print("<html><body>");
		out.print("<h1> Welcome user to cookie2</h1>");
		response.addCookie(ck1);
		Cookie[] carr=request.getCookies();
		for(Cookie obj:carr) {
			out.print(obj.getName()+" "+obj.getValue());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
