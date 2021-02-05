<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap" />
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	membersMap.put("id", "park42");
	membersMap.put("pwd", "1234");
	membersMap.put("name", "박지성");
	membersMap.put("email","park@test.com");
%>

<%
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@test.com");
	membersList.add(m1);
	membersList.add(m2);
	membersMap.put("membersList",membersList);
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
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
	</tr>
	<tr>
		<td>${membersMap.id}</td>
		<td>${membersMap.pwd}</td>
		<td>${membersMap.name}</td>
		<td>${membersMap.email}</td>
	</tr>
	<tr>
		<td>${membersMap.membersList[0].id}</td>
		<td>${membersMap.membersList[0].pwd}</td>
		<td>${membersMap.membersList[0].name}</td>
		<td>${membersMap.membersList[0].email}</td>
	</tr>
	<tr>
		<td>${membersMap.membersList[1].id}</td>
		<td>${membersMap.membersList[1].pwd}</td>
		<td>${membersMap.membersList[1].name}</td>
		<td>${membersMap.membersList[1].email}</td>
	</tr>
</table>

</body>
</html>