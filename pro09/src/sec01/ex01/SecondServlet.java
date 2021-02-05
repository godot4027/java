package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		
		out.print("<html><body>");
		
		if(id != null && id.length() != 0) {
			out.print("<p>이미 로그인상태입니다.</p><br/>");
			
			out.print("첫 번째 서블릿에서 넘겨준 아이디 :" + id +"<br/>");
			out.print("첫 번째 서블릿에서 넘겨준 비밀번호 :" + pw +"<br/>");
			out.print("첫 번째 서블릿에서 넘겨준 주소 :" + address +"<br/>");
		}else {
			out.print("<p>로그인 하지 않았습니다.</p><br/>");
			out.print("<p>다시 로그인하세요!</p>");
			out.print("<a href='/pro09/login.html'>로그인창으로 이동하기</a>");
		}
		out.print("</body></html>");
		
		
		
		
	}

}
