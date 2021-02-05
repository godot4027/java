<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"
import="java.util.*, sec01.ex01.MemberBean"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	List mebersList = new ArrayList();
	MemberBean m1 = new MemberBean("son","1234","손흥민","son@test.com");
	MemberBean m2 = new MemberBean("ki","1234","기성용","ki@test.com");
	MemberBean m3 = new MemberBean("park","1234","박지성","park@test.com");
	mebersList.add(m1);
	mebersList.add(m2);
	mebersList.add(m3);
	
%>

<c:set var="lists" value="<%=mebersList %>" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:30%;">
		<tr bgcolor="lightgreen">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="data" items="${lists}">
		<tr>
			<td>${data.id}</td>
			<td>${data.pwd}</td>
			<td>${data.name}</td>
			<td>${data.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>