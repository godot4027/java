package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		
		out.print("<html><body>");
		
		if(id != null && id.length() != 0) {
			out.print("<p>�̹� �α��λ����Դϴ�.</p><br/>");
			
			out.print("ù ��° �������� �Ѱ��� ���̵� :" + id +"<br/>");
			out.print("ù ��° �������� �Ѱ��� ��й�ȣ :" + pw +"<br/>");
			out.print("ù ��° �������� �Ѱ��� �ּ� :" + address +"<br/>");
		}else {
			out.print("<p>�α��� ���� �ʾҽ��ϴ�.</p><br/>");
			out.print("<p>�ٽ� �α����ϼ���!</p>");
			out.print("<a href='/pro09/login.html'>�α���â���� �̵��ϱ�</a>");
		}
		out.print("</body></html>");
		
		
		
		
	}

}
