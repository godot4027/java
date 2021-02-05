<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="context" value="${pageContext.request.contextPath}" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty param.id}">
	<p>아이디를 입력해주세요</p>
	<a href="${context}/test04/login.jsp">로그인창으로</a>
</c:if>

<c:if test="${not empty param.id}">
	<c:choose>
		<c:when test="${param.id == 'admin'}">
			<h1>관리자로 로그인 했습니다.</h1>
			<input type="button" value="회원정보 삭제하기" />
			<input type="button" value="회원정보 수정하기" />
		</c:when>
		<c:when test="${param.id != 'admin'}">
			<h1>환영합니다 ${param.id}님!!!</h1>
		</c:when>
	</c:choose>

</c:if>

</body>
</html>