<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>안녕하세요 쇼핑몰 중심 JSP 쇼핑몰입니다.</p>
	<br/>
	<jsp:include page="duke_image.jsp">
		<jsp:param value="듀크2" name="name"/>
		<jsp:param value="duke2.png" name="imgSrc"/>
	</jsp:include>
	
	
	
</body>
</html>