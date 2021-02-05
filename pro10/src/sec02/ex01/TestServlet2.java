package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); //컨텍스트 이름
		String url = request.getRequestURL().toString(); //전체 url 나타냅니다.
		String mapping = request.getServletPath(); //서블릿 매핑 이름만 가져옵니다.
		String uri = request.getRequestURI().toString(); 
		
		out.print("<html>");
		out.print("<head><title>Test Servlet2</title></head>");
		out.print("<body bgcolor='red'>");
		out.print("<b>컨텐스트 이름 : </b>"+context+"<br/>");
		out.print("<b>전체 경로 : </b>"+url+"<br/>");
		out.print("<b>매핑 이름 : </b>"+mapping+"<br/>");
		out.print("<b>URI : </b>"+uri+"<br/>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
