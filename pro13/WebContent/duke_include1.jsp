<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	
	<p>안녕하세요 쇼핑몰 중심 JSP 쇼핑몰입니다.</p>
	<br/>
	<jsp:include page="duke_image.jsp" flush="true">
		<jsp:param value="듀크" name="name"/>
		<jsp:param value="duke.png" name="imgSrc"/>
	</jsp:include>
	
</body>
</html>