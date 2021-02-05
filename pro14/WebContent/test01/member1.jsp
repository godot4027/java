<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회1</title>
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
		<td><%=id %></td>
		<td><%=pwd %></td>
		<td><%=name %></td>
		<td><%=email %></td>
	</tr>
	<tr>
		<td>${param.id}</td>
		<td>${param.pwd}</td>
		<td>${param.name}</td>
		<td>${param.email}</td>
	</tr>
</table>
</body>
</html>