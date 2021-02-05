<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="test1" scope="page"></c:set>
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="김테스트" scope="page"></c:set>
<c:set var="age" value="29" scope="page"></c:set>
<c:set var="height" value="174" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="width:30%;">
	<tr bgcolor="lightgreen">
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>키</th>
	</tr>
	<tr>
	<c:choose >
		<c:when test="${empty name}">
			
				<td colspan="5">아이디를 입력해주세요.</td>
			
		</c:when>
		<c:otherwise>
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${age}</td>
			<td>${height}</td>
		</c:otherwise>
	</c:choose>
	</tr>
</table>

	


</body>
</html>