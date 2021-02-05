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
		String msg = request.getParameter("msg");
	
		if(msg != null){
	%>
		<h1><%=msg %></h1>
	<%} %>
	
	<form action="result.jsp" method="post">
		아이디 : <input type="text" name="id"/><br>
		비밀번호 : <input type="password" name="pwd" id="" /><br>
		<input type="submit" value="전송" />
		<input type="reset" value="다시쓰기" />
	</form>
	
</body>
</html>