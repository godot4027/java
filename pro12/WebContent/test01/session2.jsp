<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 테스트2</title>
</head>
<body>
	<h1><%=name %></h1>
	<p><%=address %></p>
</body>
</html>