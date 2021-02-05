package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
@WebServlet("/sess02")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		out.print("<html><body>");
		out.print("세션 아이디 : " + session.getId() + "<br/>");
		out.print("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br/>");
		out.print("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br/>");
		out.print("기본 세선 유효 시간 : " + session.getMaxInactiveInterval() + "<br/>");
		session.setMaxInactiveInterval(5);
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br/>");
		
		if(session.isNew()) {
			out.print("새 세션이 만들어 졋습니다.");
			
		}
		out.print("</body></html>");
		
		
			
		
		
	}

}
