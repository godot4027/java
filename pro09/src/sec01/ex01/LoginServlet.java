package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String tell = request.getParameter("tell");
		
		String data = "";
		data += "<html><body>";
		data += "<p>�ȳ��ϼ���!</p>";
		data += "<p>�α����ϼ̽��ϴ�.</p>";
		data += "<p>���̵� : "+id+"</p>";
		data += "<p>��й�ȣ : "+pw+"</p>";
		data += "<p>�ּ� : "+address+"</p>";
		data += "<p>email : "+email+"</p>";
		data += "<p>�޴� ��ȭ : "+tell+"</p>";
		address = URLEncoder.encode(address, "utf-8");
		out.print("<a href='/pro09/second?id="+id+"&pw="+pw+"&address="+address+"'>�� ��° �������� ������</a>");
		
		data += "</body></html>";
		out.print(data);
		
		
		
	}

}
