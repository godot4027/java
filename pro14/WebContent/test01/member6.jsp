<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false" import="sec02.ex01.*"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>    

<jsp:useBean id="m1" class="sec02.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="addr" class="sec02.ex01.Address"/>
<jsp:setProperty property="city" name="addr" value="서울"/>
<jsp:setProperty property="zipcode" name="addr" value="07654"/>

<%
	m1.setAddr(addr);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>도시</th>
				<th>우편번호</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${m1.id}</td>
				<td>${m1.pwd}</td>
				<td>${m1.name}</td>
				<td>${m1.email}</td>
				<td><%=m1.getAddr().getCity() %></td>
				<td><%=m1.getAddr().getZipcode() %></td>
			</tr>
			<tr>
				<td>${m1.id}</td>
				<td>${m1.pwd}</td>
				<td>${m1.name}</td>
				<td>${m1.email}</td>
				<td>${m1.addr.city}</td>
				<td>${m1.addr.zipcode}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>