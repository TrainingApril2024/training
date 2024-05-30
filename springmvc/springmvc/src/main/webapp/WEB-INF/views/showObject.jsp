<%@page import="com.apex.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	out.println(request.getAttribute("user"));
	User user = (User) request.getAttribute("user");
	out.println(user.getName());
	%>
</body>
</html>