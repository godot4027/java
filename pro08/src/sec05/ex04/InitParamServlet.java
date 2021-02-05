package sec05.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/sinit", 
				"/sinit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "godot4027@naver.com"), 
				@WebInitParam(name = "tel", value = "010-8597-1670")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
		out.print("<p>�̸��� : "+ email+"</p>");
		out.print("<p>��ȭ��ȣ : "+ tel+"</p>");
		out.print("</body></html>");
		out.close();
		
		
	}

}
