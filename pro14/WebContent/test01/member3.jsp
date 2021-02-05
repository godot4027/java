<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%

%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m"/>
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
		<th>이메이</th>
	</tr>
	<tr>
		<td><%=m.getId() %></td>
		<td><%=m.getPwd() %></td>
		<td><%=m.getName() %></td>
		<td><%=m.getEmail() %></td>
	</tr>
	<tr>
		<td>${m.id}</td>
		<td>${m.pwd}</td>
		<td>${m.name}</td>
		<td>${m.email}</td>
	</tr>
</table>
</body>
</html>