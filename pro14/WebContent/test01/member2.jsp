<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<th>주소</th>
	</tr>
	<tr>
		<td>${param.id}</td>
		<td>${param.pwd}</td>
		<td>${param.name}</td>
		<td>${param.email}</td>
		<td>${requestScope.address}</td>
	</tr>
</table>
</body>
</html>