package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet2
 */
@WebServlet("/member8")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			
			
			dao.addMember(vo);
			
			
		}else if(command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			
			dao.delMember(id);
		}
		
		
		
		
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>아이디</th>");
		out.print("<th>비밀번호</th>");
		out.print("<th>이름</th>");
		out.print("<th>이메일</th>");
		out.print("<th>가입일자</th>");
		out.print("<th>삭제여부</th>");
		out.print("</tr>");
		List list = dao.memberJoin();
		for(int i = 0; i < list.size(); i++) {
			MemberVO memberVO = (MemberVO) list.get(i);
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td>"+pwd+"</td>");
			out.print("<td>"+name+"</td>");
			out.print("<td>"+email+"</td>");
			out.print("<td>"+joinDate+"</td>");
			out.print("<td><a href='/chap07/member8?command=delMember&id="+id+"'>삭제</a></td>");
			out.print("/<tr>");
		
		} 
		out.print("</table>");
		out.print("</body>");
		out.print("<a href='/chap07/memberForm.html'>회원가입 페이지로</a>");
		out.print("</html>");
		
		
	}

}
