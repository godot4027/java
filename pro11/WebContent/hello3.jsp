<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%!
		String name = "이순신";
	%>
	
	<%
		String age = request.getParameter("age");
	%>


	<h1>안녕하세요 <%=name %>님!</h1>
	<h2>나이는 <%=age %>살입니다.</h2>
	<h3>키는 <%=180 %>cm 입니다.</h3>
	<h4>나이+10은 <%= Integer.parseInt(age) + 10%>살입니다!!</h4>
</body>
</html>