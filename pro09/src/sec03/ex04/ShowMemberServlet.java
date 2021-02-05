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
 * Servlet implementation class ShowMemberServlet
 */
@WebServlet("/show")
public class ShowMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id = "";
		String pw = "";
		Boolean isLogOn = false;
		//이미 세션이 존재하면 세션을 반환하고, 없으면 null로 반환
		HttpSession session = request.getSession(false);
		//세션이 있는확인한다
		if(session != null) {
			isLogOn= (Boolean) session.getAttribute("isLogOn");
			if(isLogOn == true) {
				//isLogOn의 상태가 true면 브라우저에 화면표시
				id = (String) session.getAttribute("login3.id");
				pw = (String) session.getAttribute("login3.pw");
				out.print("<html><body>");
				out.print("아이디 : " + id + "<br/>");
				out.print("비밀번호 : " + pw + "<br/>");
				out.print("</body></html>");
			}else {
				//로그인상태가아니면 로그인창으로 리다이렉트이동
				response.sendRedirect("login3.html");
			}
			
		}else {
			//세션이 생성되었지않다면 로그인창으로 리다이렉트 이동
			response.sendRedirect("login3.html");
		}
		
		
		
		
		
		
	}

}
