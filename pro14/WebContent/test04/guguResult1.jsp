<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="guguDan" value="${param.gugu}" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="30%">
		<tr>
			<th colspan="2" align="center" bgcolor="skyblue">${guguDan}단 출력</th>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
				<td>${guguDan} * ${i}</td>
				<td>${guguDan * i}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>