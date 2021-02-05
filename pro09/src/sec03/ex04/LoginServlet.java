package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet3", urlPatterns = { "/login3" })
public class LoginServlet extends HttpServlet {
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
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//입력된 id와 pw값 가져오기
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//아이디값을 vo객체 생성후 id,pw 값 생성
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		//DAO의 EX 메소드에 값 연결
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isExisted(memberVO);
		
		
		if(result) {
			HttpSession session = request.getSession();
			//조회한 결과가 true면 isLogOn 속성의 값을 true로 세션에 저장합니다.
			session.setAttribute("isLogOn", true);
			//조회한 결과가 true면 id,pw 값을 세션에 저장합니다.
			session.setAttribute("login3.id", user_id);
			session.setAttribute("login3.pw", user_pw);
			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!!!<br/>");
			out.print("<a href='show'>회원정보 보기</a>");
			out.print("</body></html>");
		}else {
			
			out.print("<html><body>회원 아이디가 틀립니다.");
			out.print("<a href='login3.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
		
		
		
	}

}
