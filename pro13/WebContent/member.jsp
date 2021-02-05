<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec01.ex01.*"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	String name = request.getParameter("user_name");
	String email = request.getParameter("user_email");
	
	MemberBean bean = new MemberBean(id, pwd, name, email);
	MemberDAO dao = new MemberDAO();
	dao.addMembers(bean);
	List membersList = dao.membersList(bean);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일자</th>
		</tr>
		<%
		for(int i = 0; i < membersList.size(); i++){
			MemberBean memberBean = (MemberBean)membersList.get(i);
			
		%>
		<tr>
			<td><%=memberBean.getId() %></td>
			<td><%=memberBean.getPwd() %></td>
			<td><%=memberBean.getName() %></td>
			<td><%=memberBean.getEmail() %></td>
			<td><%=memberBean.getJoinDate() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>