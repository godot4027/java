package sec03.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowMemberServlet3
 */
@WebServlet("/show3")
public class ShowMemberServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = "";
		String pwd = "";
		boolean isLogOn;
		
		//세션이 있으면 값 반환하고 세션이없으면 null 반환한다.
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			isLogOn = (boolean) session.getAttribute("isLogOn");
			if(isLogOn == true) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pw");
				
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
