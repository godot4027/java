<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String) request.getAttribute("name");
	String address = (String) request.getAttribute("address");
	System.out.println("2로 요청받음");
%>  



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체2</title>
</head>
<body>
	<h1>이름은 <%=name %> 입니다.</h1>
	<p><%= address %></p>
</body>
</html>