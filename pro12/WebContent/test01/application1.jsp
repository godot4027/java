<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setAttribute("name", "이순신");
	application.setAttribute("address", "주소는 서울시 성동구 입니다.");
%>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름과 주소를 저장합니다.</h1>
	<a href="./application2.jsp">두번째 웹페이지로 이동</a>
</body>
</html>