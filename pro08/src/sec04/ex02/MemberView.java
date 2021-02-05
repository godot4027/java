package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberView
 */
@WebServlet("/memberView")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List memberList = (List) request.getAttribute("membersList");
		
		out.print("<html><body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>아이디</th>");
		out.print("<th>비밀번호</th>");
		out.print("<th>이름</th>");
		out.print("<th>이메일</th>");
		out.print("<th>가입일자</th>");
		out.print("<th>삭제여부</th>");
		out.print("</tr>");
		
		for(int i = 0; i < memberList.size(); i++) {
			MemberVO memberVO = (MemberVO) memberList.get(i);
			
			String id = memberVO.getId();
			String pwd= memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			MemberVO vo = new MemberVO();
			
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinDate);
			
			out.print("<tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td>"+pwd+"</td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+email+"</td>");
			out.print("<td>"+joinDate+"</td>");
			out.print("<td><a href='/pro08/member?command=delMember&id="+id+"'>삭제</a></td>");
			out.print("</tr>");
			
		}
		
		out.print("</table>");
		out.print("<a href='/pro08/memberForm.html'>회원가입 페이지로 이동</a>");
		out.print("</body></html>");
	}

}
