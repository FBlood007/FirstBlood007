<%@ page import="java.util.ArrayList,java.sql.Connection" isELIgnored="false"%>
  <%@  include file="header.jsp"%>
  <%@page import="com.tqpp.Student1" %>
<%-- <%@ taglib prefix="" uri="" %>     --%>

<%ArrayList<Student1> arr = (ArrayList<Student1>)request.getAttribute("stu");%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
th, td {
  background-color: #96D4D4;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to my first jsp page</h1>
<%-- Name <%=request.getParameter("snm")%><br> --%>
<%-- Percent <%=request.getParameter("percent")%><br> --%>
<%-- City <%=request.getParameter("city") %><br> --%>


<table >
<tr>
<th>Id</th>
<th>Name</th>
<th>Percent</th>
<th>City</th>
</tr>

<%
// ArrayList<Student1> arr = (ArrayList<Student1>)request.getAttribute("stu");
for(Student1 s : arr){ %>
	<tr><th><%out.println(s.getSid());%></th>
	<th><%out.println(s.getSname()); %></th>
	<th><%out.println(s.getPercent()); %></th>
	<th><%out.println(s.getCity()); %></th></tr>
<% }
%>
</table>
<%-- Name ${snm} --%>
<%



// ArrayList<String> al = new ArrayList<>();
// al.add("jog");
// al.add("gso");
// al.add("Sdo");
// al.add("sd");
//out.println(al);
%>


<%
// for(int i=1;i<=10;i++)
		//out.println(i);
%>

</body>
</html>

<%-- Scriplet <% %> 

	declaration tag <%! %>
	
	expression tag <%=req. %>
	
	directives <%@page %>



--%>