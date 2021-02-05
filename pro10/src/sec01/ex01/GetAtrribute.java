package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAtrribute
 */
@WebServlet("/get")
public class GetAtrribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();	
		HttpSession session = request.getSession();
		
		String ctxMesg = (String) ctx.getAttribute("Context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("ServletContext : " + ctxMesg + "<br/>");
		out.print("HttpSession : " + sesMesg + "<br/>");
		out.print("Request : " + reqMesg + "<br/>");
		
		
		
	}

}
