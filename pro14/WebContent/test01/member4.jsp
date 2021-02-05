<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec01.ex01.*"
	isELIgnored="false"
    pageEncoding="UTF-8"%>

<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="membersList" class="java.util.ArrayList" />

<%
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@test.com");
	membersList.add(m1);
	membersList.add(m2);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		<tr>
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>
</body>
</html>