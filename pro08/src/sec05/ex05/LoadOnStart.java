package sec05.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadOnStart
 */
@WebServlet(name = "loadOnStart", urlPatterns = { "/loadOnStart" }, loadOnStartup = 1)
public class LoadOnStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출성공");
		context = config.getServletContext();
		
		String memberJoin = context.getInitParameter("member_join");
		String memberOrder = context.getInitParameter("member_order");
		String memberGoods = context.getInitParameter("member_list");
		
		context.setAttribute("memberJoin", memberJoin);
		context.setAttribute("memberOrder", memberOrder);
		context.setAttribute("memberGoods", memberGoods);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
//		ServletContext context = getServletContext();
		
		PrintWriter out = response.getWriter();
		
		String memberJoin = (String) context.getAttribute("memberJoin");
		String memberOrder = (String) context.getAttribute("memberOrder");
		String memberGoods = (String) context.getAttribute("memberGoods");
		
		out.print("<html><body>");
		out.print("<table>");
		out.print("<tr><td>"+memberJoin+"</td></tr>");
		out.print("<tr><td>"+memberOrder+"</td></tr>");
		out.print("<tr><td>"+memberGoods+"</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
		out.close();
	}

}
