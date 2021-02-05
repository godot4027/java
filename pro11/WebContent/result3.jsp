<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 일반 사용자 출력</title>
</head>
<body>
	
	<%
		String user_id =request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
	%>
	
	<%
		if(user_id == null || user_id.length() == 0){	
	%>
		<p>아이디를 확인해주세요.</p>
		<a href="login.jsp">로그인페이지로 이동</a>
	
	<%} else {
		
		if(user_id.equals("admin")){
			
	%>		
		<h1>관리자로 로그인 하셨습니다.</h1>
		<form>
			<input type="button" value="회원정보 삭제하기">
			<input type="button" value="회원정보 수정하기">
		</form>
	
	
	<%		} else { %>
			<h1>환영합니다 <%=user_id %> 님!!!!</h1>
			
	
	<%      } %>
		
		
		
		
	
	<%} %>
	
</body>
</html>