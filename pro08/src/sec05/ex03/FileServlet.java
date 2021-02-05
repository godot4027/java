package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/cfile")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
		
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is)); 
		
		String menu = null;
		String menu_member = null;
		String memu_order = null;
		String memu_goods = null;
		
		while((menu = buffer.readLine()) != null) {
			StringTokenizer token = new StringTokenizer(menu, ",");
			menu_member = token.nextToken();
			memu_order = token.nextToken();
			memu_goods = token.nextToken();
		}
		
		out.print("<html></body>");
		out.print("<table>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+memu_order+"</td></tr>");
		out.print("<tr><td>"+memu_goods+"</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
		
		
		
		
	}

}
