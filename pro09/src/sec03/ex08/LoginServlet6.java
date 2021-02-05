package sec03.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet6
 */
@WebServlet(name = "LoginServlet7", urlPatterns = { "/login7" })
public class LoginServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isexited(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pw", pwd);
			
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + id + "��!!!<br/>" );
			out.print("<a href='show6'>ȸ����������</a>");
			out.print("</body></html>");
			
			
		}else {
			
			out.print("<html><body>");
			out.print("���̵�� ��й�ȣ�� ����� �Է����ּ���.<br/>");
			out.print("<a href='login3.html'>�α���â���� �̵�</a>");
			out.print("</body></html>");
		}
				
		
		
	}

}
