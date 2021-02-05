<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿 연습</title>
</head>
<body>
	<%!
		String name="이순신";
	
		public String getName(){
			return name;
		}
		
	%>
	
	<%
		String age = request.getParameter("age");
	%>
	
	<h1>안녕하세요 <%= name %>님!</h1>
	<h2>나이는 <%=age %>살 입니다.</h2>
	
	
</body>
</html>