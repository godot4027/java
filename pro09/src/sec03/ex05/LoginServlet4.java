package sec03.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
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
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//���۵� ���� ���̵�� pw���� �����´�
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
		//memberVO ��ü ������ ���̵�� ��й�ȣ �� ����
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		
		//memberDAO�� memberVO ��ü �߰�
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isExisted(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pwd", pwd);
			
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + id + "��!!!<br/>");
			out.print("<a href='show2'>ȸ������ ����</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>");
			out.print("ȸ�� ���̵� Ʋ���ϴ�.<br/>");
			out.print("<a href='login3.html'>�ٽ÷α����ϱ�</a>");
			out.print("</body></html>");
		}
		
		
	}

}
