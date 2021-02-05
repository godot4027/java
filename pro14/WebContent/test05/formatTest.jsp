<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포매팅 태그 라이브러리 예제</title>
</head>
<body>
	<h2>fmt의 number 태그를 이용한 숫자 포맷팅 예제</h2>
	<c:set var="price" value="100000000"></c:set>
	
	<fmt:formatNumber value="${price}" type="number" var="priceNumber"></fmt:formatNumber>
	통화로표현시 : 
	<fmt:formatNumber type="currency" currencySymbol="\" value="${price}"></fmt:formatNumber>
	
	
</body>
</html>