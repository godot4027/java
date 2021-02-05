<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
</head>
<body>
	<form action="memberAction.jsp" method="post">
		아이디 : <input type="text" name="id" id="" /> <br />
		비밀번호 : <input type="text" name="pwd" id="" /><br />
		이름 : <input type="text" name="name" id="" /><br />
		이메일 : <input type="text" name="email" id="" /><br />
		<input type="submit" value="로그인" />
		<input type="reset" value="다시쓰기" />
		<input type="hidden" name="command" value="addMember"/>
	</form>
</body>
</html>