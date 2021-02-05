package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet3", urlPatterns = { "/login3" })
public class LoginServlet extends HttpServlet {
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
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//�Էµ� id�� pw�� ��������
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//���̵��� vo��ü ������ id,pw �� ����
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		//DAO�� EX �޼ҵ忡 �� ����
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isExisted(memberVO);
		
		
		if(result) {
			HttpSession session = request.getSession();
			//��ȸ�� ����� true�� isLogOn �Ӽ��� ���� true�� ���ǿ� �����մϴ�.
			session.setAttribute("isLogOn", true);
			//��ȸ�� ����� true�� id,pw ���� ���ǿ� �����մϴ�.
			session.setAttribute("login3.id", user_id);
			session.setAttribute("login3.pw", user_pw);
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + user_id + "��!!!!<br/>");
			out.print("<a href='show'>ȸ������ ����</a>");
			out.print("</body></html>");
		}else {
			
			out.print("<html><body>ȸ�� ���̵� Ʋ���ϴ�.");
			out.print("<a href='login3.html'>�ٽ� �α����ϱ�</a>");
			out.print("</body></html>");
		}
		
		
		
	}

}
