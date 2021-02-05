<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"
import="java.util.*, sec01.ex01.MemberBean"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
	List membersList = new ArrayList();
	MemberBean m1 = new MemberBean("son","1234","손흥민","son@test.com");
	MemberBean m2 = new MemberBean("ki","1234","기성용","ki@test.com");
	MemberBean m3 = new MemberBean("park","1234","박지성","park@test.com");
	membersList.add(m1);
	membersList.add(m2);
	membersList.add(m3);
%>
<c:set var="members" value="<%= membersList%>" scope="page"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="width:30%;">
	<tr bgcolor="lightgreen">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
	</tr>
	
	<c:forEach var="i" begin="0" end="2" step="1">
	<tr>
		<td>${members[i].id}</td>
		<td>${members[i].pwd}</td>
		<td>${members[i].name}</td>
		<td>${members[i].email}</td>
	</tr>
	</c:forEach>
	
	
</table>
</body>
</html>