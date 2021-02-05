<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" import="java.util.*, sec01.ex01.MemberBean"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="membersList" class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="memberMap" class="java.util.HashMap"></jsp:useBean>

<%
	request.setCharacterEncoding("utf-8");
	
	
	memberMap.put("id","park2");
	memberMap.put("pwd", "4321");
	memberMap.put("name","박지성");
	memberMap.put("email","park2@test.com");
	MemberBean m1 = new MemberBean("son","1234","손흥민","son@test.com");
	MemberBean m2 = new MemberBean("ki","1234","기성용","ki@test.com");
	membersList.add(m1);
	membersList.add(m2);
	memberMap.put("membersList",membersList);
%>

<c:set var="memberList" value="${memberMap.membersList}" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="lightgreen">
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${memberMap.id}</td>
			<td>${memberMap.pwd}</td>
			<td>${memberMap.name}</td>
			<td>${memberMap.email}</td>
		</tr>
		<tr>
			<td>${memberMap.membersList[0].id}</td>
			<td>${memberMap.membersList[0].pwd}</td>
			<td>${memberMap.membersList[0].name}</td>
			<td>${memberMap.membersList[0].email}</td>
		</tr>
		<tr>
			<td>${memberList[1].id}</td>
			<td>${memberList[1].pwd}</td>
			<td>${memberList[1].name}</td>
			<td>${memberList[1].email}</td>
		</tr>
	</table>
</body>
</html>