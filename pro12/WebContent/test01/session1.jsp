<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String) session.getAttribute("name");

	session.setAttribute("address", "주소는 서울시 강남구입니다.");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 테스트1</title>
</head>
<body>
	<h1>이름은 <%= name %> 입니다.</h1>
	<a href="session2.jsp">두번째 페이지로 이동하기</a>
</body>
</html>