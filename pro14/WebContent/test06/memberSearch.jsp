<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색창</title>
</head>
<body>
	<form action="memberAction.jsp" method="post">
		이름 : <input type="text" name="name" id="" /> <br />
		<input type="submit" value="검색" />
		<input type="hidden" name="command" value="searchMember"/>
	</form>
</body>
</html>