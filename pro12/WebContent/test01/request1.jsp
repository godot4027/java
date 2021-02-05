<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name", "이순신");
	request.setAttribute("address","주소는 서울시 노원구입니다.");
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
	dispatcher.forward(request, response);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체1</title>
</head>
<body>
	
</body>
</html>