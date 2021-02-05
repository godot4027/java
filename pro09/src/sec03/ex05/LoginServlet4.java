package sec03.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//전송된 유저 아이디와 pw값을 가져온다
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
		//memberVO 객체 생성후 아이디와 비밀번호 값 세팅
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		//memberDAO에 memberVO 객체 추가
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isExisted(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pwd", pwd);
			
			out.print("<html><body>");
			out.print("안녕하세요 " + id + "님!!!<br/>");
			out.print("<a href='show2'>회원정보 보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>");
			out.print("회원 아이디가 틀립니다.<br/>");
			out.print("<a href='login3.html'>다시로그인하기</a>");
			out.print("</body></html>");
		}
		
		
	}

}
