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
 * Servlet implementation class ShowMemberServlet2
 */
@WebServlet("/show2")
public class ShowMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMemberServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id ="";
		String pwd = "";
		boolean isLogOn = false;
		//������ �ִ�Ȯ���Ѵ� ������ �����ϸ� true �������������������� null ��ȯ
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			isLogOn = (boolean) session.getAttribute("isLogOn");
			System.out.println("asdasdadssda");
			if(isLogOn == true) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				System.out.println("id : " + id );
				System.out.println("pwd : " + pwd );
				out.print("<html><body>");
				out.print("���̵� : " + id + "<br/>");
				out.print("��й�ȣ : " + pwd); 
			}else {
				response.sendRedirect("login3.html");
			}
		} else {
			response.sendRedirect("login3.html");
		}
	}

}
