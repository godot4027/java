<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="sec03.ex01.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>
</head>
<body>
<table border="1" width="100%">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	
	<c:forEach var="data" items="${membersList}">
		<tr>
			<td>${data.id}</td>
			<td>${data.pwd}</td>
			<td>${data.name}</td>
			<td>${data.email}</td>
			<td>${data.joinDate}</td>
		</tr>
	</c:forEach>
	
	
</table>



</body>
</html>