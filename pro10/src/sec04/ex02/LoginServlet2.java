package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet(name = "LoginServlet3", urlPatterns = { "/login3" })
public class LoginServlet2 extends HttpServlet {
	
	ServletContext context = null;
	List user_list = new ArrayList();
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		context = getServletContext();
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		Loginimpl user_login = new Loginimpl(user_id, user_pw);
		
		if(session.isNew()) {
			session.setAttribute("user_login", user_login);
			user_list.add(user_id);
			context.setAttribute("user_list", user_login);
		}
		
		out.print("<html><body>");
		out.print("총 접속자수는 : " + user_login.user_num + "<br/>");
		out.print("접속 아이디 : <br/>");
		List list = (ArrayList) context.getAttribute("user_login");
		for(int i = 0; i < list.size(); i++) {
			out.print(list.get(i) + "<br/>");
		}
		out.print("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
		
	}

}
