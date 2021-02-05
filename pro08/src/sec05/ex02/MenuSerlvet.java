package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuSerlvet
 */
@WebServlet("/menu")
public class MenuSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}

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
		
		ServletContext context = getServletContext();
		
		String memberJoin = context.getInitParameter("member_join");
		String memberOrder = context.getInitParameter("member_order");
		String memberList = context.getInitParameter("member_list");
		
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>"+memberJoin+"</td></tr>");
		out.print("<tr><td>"+memberOrder+"</td></tr>");
		out.print("<tr><td>"+memberList+"</td></tr>");
		out.print("</body></html>");
		
		
		
		
	}

}
