<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String msg = "아이디가 입력되지 않았습니다. 다시입력해주세요.";
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(id.length() == 0){
%>
	<jsp:forward page="login.jsp">
		<jsp:param value="<%=msg %>" name="msg"/>
	</jsp:forward>
<%
}else{
%>
	<h1>환영합니다. <%=id %>님!!</h1>
<% 	
}
%>

	
</body>
</html>