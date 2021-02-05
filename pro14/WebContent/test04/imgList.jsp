<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지출력</title>
</head>
<body>
	<table border="1" width="50%">
		<tr>
			<th>이미지</th>
			<th>이미지이름</th>
			<th>선택하기</th>
		</tr>
		<c:forEach var="i" begin="1" end="10" step="1">
			<tr>
				<td>
					<img src="/pro14/images/duke.png" alt="" />
				</td>
				<td>
					이미지 이름 : 듀크${i}
				</td>
				<td>
					<input type="checkbox" name="dukeCheck" id="duckCheck${i}" />
				</td>			
			</tr>
		</c:forEach>
	</table>
</body>
</html>