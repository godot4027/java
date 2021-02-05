<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" import="java.util.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="context" value="${pageContext.request.contextPath}" scope="page"/>
<%
	System.out.println("전송완료");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${context}/upload.do" method="post" enctype="multipart/form-data">
	파일 1 : <input type="file" name="file1" id="" /> <br />
	파일 2 : <input type="file" name="file2" id="" /> <br />
	매개변수 1 <input type="hidden" name="param1" value="" /> <br />
	매개변수 2 <input type="hidden" name="param2" value="" /> <br />
	매개변수 3 <input type="hidden" name="param3" value="" /> <br />
	<input type="submit" value="전송" />
	</form>
</body>
</html>