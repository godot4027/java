<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	request.setCharacterEncoding("utf-8");
	List lists = new ArrayList();
	lists.add("hello");
	lists.add("world");
	lists.add("안녕하세요!");
%>
<c:set var="list" value="<%=lists %>" scope="page"></c:set>
<body>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i=${i} &nbsp;&nbsp;&nbsp;반복횟수: ${loop.count} <br />
	</c:forEach>
	<br />
	
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i}  = ${5*i} <br /> 
	</c:forEach>
	<br />
	
	<c:forEach var="data" items="${list}">
		${data} <br />
	</c:forEach>
	<br />
	
	<c:set var="fruits" value="사과- 파인애플- 바나나- 망고- 귤" scope="page"></c:set>
	<c:forTokens var="data" items="${fruits}" delims="-" >
		${data} <br />
	</c:forTokens>
</body>
</html>