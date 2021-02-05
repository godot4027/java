<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String imgSrc = request.getParameter("imgSrc");
	String name = request.getParameter("name");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 이미지</title>
</head>
<body>
	<h1>이름은 <%=name %> 입니다!</h1>
	<img alt="" src="/pro13/images/<%=imgSrc %>">
</body>
</html>