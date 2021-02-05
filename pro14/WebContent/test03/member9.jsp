<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<table style="width:30%;" border="1">
		<tr bgcolor="lightgreen">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${empty param.id}">
					<td colspan="5">아이디를 입력해주세요</td>
				</c:when>
				<c:otherwise>
					<td><c:out value="${param.id}"></c:out></td>
					<td><c:out value="${param.pwd}"></c:out></td>
					<td><c:out value="${param.name}"></c:out></td>
					<td><c:out value="${param.email}"></c:out></td>
					<td><c:out value="${param.address}" default="서울시 노원구"></c:out></td> 
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>