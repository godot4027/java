package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");

		if(session.isNew()) {
			session.setAttribute("user_id", user_id);
		}
		
		Loginimpl loginImpl = new Loginimpl(user_id, user_pw);
		session.setAttribute("loginImpl", loginImpl);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<script>");
		out.print("setTimeout('history.go(0);',5000)");
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 : " + loginImpl.user_id + "<br/>");
		out.print("총 접속자수 : " + loginImpl.number + "명");
		out.print("</body></html>");
		
	}

}
