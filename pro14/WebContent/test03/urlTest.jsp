<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
 %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="url" value="/test03/member1.jsp">
		<c:param name="id" value="godot4027"></c:param>
		<c:param name="pwd" value="guswls12"></c:param>
		<c:param name="name" value="김현진"></c:param>
		<c:param name="email" value="godot4027@naver.com"></c:param>
	</c:url>
	
	<a href="${url}">회원정보출력</a>
</body>
</html>