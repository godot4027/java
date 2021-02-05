package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/get")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieValue = request.getCookies();
		
		for(int i = 0; i < cookieValue.length; i++) {
			
			if(cookieValue[i].getName().equals("cookieTest")) {
				out.print("<html><body>");
				out.print("<strong>가져온 쿠키의 값은 "+ URLDecoder.decode(cookieValue[i].getValue(),"utf-8")+"</strong>");
				out.print("</body></html>");
				
			}
		}
		
		
	}

}
