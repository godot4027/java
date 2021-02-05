package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	//�켱 4���� ���� ����
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	
	Connection con;
	Statement stmt;
	
	List<MemberVO> listMembers(){
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			String query = "select * from t_member";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinDate);
			list.add(vo);
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("driver ���� ����");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection ���� ����");
			stmt = con.createStatement();
			System.out.println("Statement ���� ����");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
