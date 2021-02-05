<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="sec03.ex01.*, java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec03.ex01.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<%
MemberBean bean = new MemberBean();
MemberDAO dao = new MemberDAO();
String command = request.getParameter("command");

System.out.println("command 넘어오는값 : " + command);
List membersList = null;
if(command.equals("searchMember")){
	membersList = dao.membersList(m);
}else if (command.equals("addMember")){
	dao.addMembers(m);
	membersList = dao.membersList();
}

request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 조회</title>
</head>
<body>
	<jsp:forward page="memberList.jsp"></jsp:forward>
</body>
</html>