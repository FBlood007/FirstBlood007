<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List,com.Model.Student" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1>Student Crud</h1>
<table border="2" >
<tr>
<th>ID</th>
<th>Name</th>
<th>Percent</th>
<th>City</th>
<td>Action</td>
</tr>
<c:forEach  var="s1" items="${studlist}">
<tr>
<td>${s1.getSid()}</td>
<td>${s1.getSname()}</td>
<td>${s1.getPercent()}</td>
<td>${s1.getCity()}</td>
<td><a href="edit?id=${s1.getSid()}">Edit</a>
<a href="delete?id=${s1.getSid()}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>