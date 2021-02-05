<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="sec02.ex01.*"

    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	MemberVO memberVO = new MemberVO();
	memberVO.setName(_name);
	MemberDAO dao = new MemberDAO();
	List membersList = dao.membersjoin(memberVO);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회 목록</title>
</head>
<body>

<h1>회원 정보 출력</h1>
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	
	<%
	if(membersList.size() == 0){
	%>
	<tr>
		<td colspan="5">검색된 결과가 없습니다.</td>
	</tr>
	
	<%}else { %>
	<%
		
	
		for(int i = 0; i < membersList.size(); i++){
		MemberVO vo = (MemberVO)membersList.get(i);
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		Date joinDate = vo.getJoinDate();
			
		
	%>
		<tr>
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>
			
		</tr>
	<%}
	}
	%>
</table>

</body>
</html>