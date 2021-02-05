<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

%>
<c:set var="score" value="${param.score}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>시험점수 ${score}</h1>
	<br /><br />
	<c:choose>
		<c:when test="${100 >= score && 90 <= score}">
			<h1>A학점 입니다.</h1>
		</c:when>
		<c:when test="${90 > score && 80 <= score}">
			<h1>B학점 입니다.</h1>
		</c:when>
		<c:when test="${80 > score && 70 <= score}">
			<h1>C학점 입니다.</h1>
		</c:when>
		<c:otherwise>
			<h1>F학점 입니다.</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>