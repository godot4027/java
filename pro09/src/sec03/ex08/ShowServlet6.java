package sec03.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowServlet6
 */
@WebServlet("/show6")
public class ShowServlet6 extends HttpServlet {
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
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pwd = "";
		boolean isLogOn = false;
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			isLogOn = (boolean) session.getAttribute("isLogOn");
			id = (String) session.getAttribute("login.id");
			pwd = (String) session.getAttribute("login.pw");
			if(isLogOn == true) {
				out.print("<html><body>");
				out.print("아이디 : " + id + "<br/>");
				out.print("비밀번호 : " + pwd);
				out.print("</body></html>");
			}else {
				response.sendRedirect("login3.html");
			}
			
		}else {
			response.sendRedirect("login3.html");
		}
		
		
	}

}
