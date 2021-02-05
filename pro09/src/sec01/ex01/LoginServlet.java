package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tell = request.getParameter("tell");
		
		String data = "";
		data += "<html><body>";
		data += "<p>안녕하세요!</p>";
		data += "<p>로그인하셨습니다.</p>";
		data += "<p>아이디 : "+id+"</p>";
		data += "<p>비밀번호 : "+pw+"</p>";
		data += "<p>주소 : "+address+"</p>";
		data += "<p>email : "+email+"</p>";
		data += "<p>휴대 전화 : "+tell+"</p>";
		address = URLEncoder.encode(address, "utf-8");
		out.print("<a href='/pro09/second?id="+id+"&pw="+pw+"&address="+address+"'>두 번째 서블릿으로 보내기</a>");
		
		data += "</body></html>";
		out.print(data);
		
		
		
	}

}
