package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FileServlet3
 */
@WebServlet("/cfile3")
public class FileServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String menu_list = null;
		String menu_order = null;
		String menu_goods = null;
		
		while((menu = buffer.readLine()) != null) {
		StringTokenizer tokens = new StringTokenizer(menu,",");
		
		menu_list = tokens.nextToken();
		menu_order = tokens.nextToken();
		menu_goods = tokens.nextToken();
		}
		System.out.println(menu_list);
		System.out.println(menu_order);
		System.out.println(menu_goods);
		
		
	}
	
	
	

}
