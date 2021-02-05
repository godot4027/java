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
 * Servlet implementation class ShowMemberServlet
 */
@WebServlet("/show")
public class ShowMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id = "";
		String pw = "";
		Boolean isLogOn = false;
		//�̹� ������ �����ϸ� ������ ��ȯ�ϰ�, ������ null�� ��ȯ
		HttpSession session = request.getSession(false);
		//������ �ִ�Ȯ���Ѵ�
		if(session != null) {
			isLogOn= (Boolean) session.getAttribute("isLogOn");
			if(isLogOn == true) {
				//isLogOn�� ���°� true�� �������� ȭ��ǥ��
				id = (String) session.getAttribute("login3.id");
				pw = (String) session.getAttribute("login3.pw");
				out.print("<html><body>");
				out.print("���̵� : " + id + "<br/>");
				out.print("��й�ȣ : " + pw + "<br/>");
				out.print("</body></html>");
			}else {
				//�α��λ��°��ƴϸ� �α���â���� �����̷�Ʈ�̵�
				response.sendRedirect("login3.html");
			}
			
		}else {
			//������ �����Ǿ����ʴٸ� �α���â���� �����̷�Ʈ �̵�
			response.sendRedirect("login3.html");
		}
		
		
		
		
		
		
	}

}
