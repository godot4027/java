<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	import="java.util.*, sec01.ex01.MemberBean"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>    
<jsp:useBean id="membersList" class="java.util.ArrayList" scope="page"></jsp:useBean>
<jsp:useBean id="membersMap" class="java.util.HashMap" scope="page"></jsp:useBean>
<%
	membersMap.put("id", "sumin");
	membersMap.put("pwd","1234");
	membersMap.put("name","이수민");
	membersMap.put("email","cwgkxmta@naver.com");
	
	MemberBean m1 = new MemberBean("hyeonjin","1234","김현진","godot4027@naver.com");
	MemberBean m2 = new MemberBean("tumi","1234","이튬니","tumi@naver.com");
	
	membersList.add(m1);
	membersList.add(m2);
	
	membersMap.put("membersList",membersList);
%>

<c:set var="mL" value="${membersMap.membersList}" scope="page"></c:set>
<c:set var="id" value="test01" scope="page"></c:set>
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="테스트1" scope="page"></c:set>
<c:set var="email" value="test1@naver.com" scope="page"></c:set>
 
<c:remove var="name"/> 
<c:remove var="email"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width:30%" align="center">
		<tr bgcolor="lightgreen">
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
			<td>${mL[1].id}</td>
			<td>${mL[1].pwd}</td>
			<td>${mL[1].name}</td>
			<td>${mL[1].email}</td>
		</tr>
		<tr>
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
		</tr>
	</table>
</body>
</html>