<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Details</h1>
<form action="save" >
id:<input type="text" name="sid" value="${sobj.getSid()}" readonly >
<br>
Name : <input type="text" name="sname" value="${sobj.getSname()}">
<br>
Percent:<input type="text" name="percent" value="${sobj.getPercent()}">
<br>
City:<input type="text" name="city" value="${sobj.getCity()}">
<br>
<input type="submit" value="Save">
</form>
</body>
</html>