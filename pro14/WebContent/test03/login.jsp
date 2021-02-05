<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="" method="post">
		아이디 : <input type="text" name="id" id="" /> <br />
		비밀번호 : <input type="password" name="pwd" id="" /> <br />
		<input type="submit" value="로그인" />
		<input type="reset" value="다시작성" />
	</form>
	<a href="${contextPath}/test03/memberForm.jsp">회원가입 하기</a>
	
</body>
</html>