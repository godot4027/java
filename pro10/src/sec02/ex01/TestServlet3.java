package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath(); //���ؽ�Ʈ ����
		String url = request.getRequestURL().toString(); //��ü url�����´�.
		String mapping = request.getServletPath(); //mapping�� �����´�
		String uri = request.getRequestURI().toString();
		
		out.print("<html>");
		out.print("<head><title>Test Servlet3</title></head>");
		out.print("<body bgcolor='blue'>");
		out.print("<b>���ٽ�Ʈ �̸� : </b>"+context+"<br/>");
		out.print("<b>��ü ��� : </b>"+url+"<br/>");
		out.print("<b>���� �̸� : </b>"+mapping+"<br/>");
		out.print("<b>URI : </b>"+uri+"<br/>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
		
	}

}