package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public  MemberDAO(){
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env/");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ȸ������ ��ȸ�ϱ�
	 * */
	
	List<MemberVO> memberJoin () {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// �����ͺ��̽� ����			
			con = dataFactory.getConnection();
			System.out.println("ȸ����ȸ �����ͺ��̽� ���Ἲ��");
			
			// ���� �۵�
			String query = "select * from t_member";
			pstmt = con.prepareStatement(query);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery(query);
			
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
			pstmt.close();
			rs.close();
			
			System.out.println("ȸ����ȸ �����ͺ��̽� ��������");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	/*
	 * ȸ������
	 * */
	
	public void addMember(MemberVO memberVO) {
		try {
			//�����ͺ��̽� ����
		
			con = dataFactory.getConnection();
			System.out.println("ȸ������ �����ͺ��̽� ���� ����");
			
			String id = memberVO.getId();
			String pwd= memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += "(id,pwd,name,email)";
			query += "values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			System.out.println(query);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("ȸ������ �����ͺ��̽� ���� ����");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * ȸ������ 
	 * */
	
	public void delMember(String id) {
		try{
			con = dataFactory.getConnection();
			System.out.println("ȸ������ �����ͺ��̽� ���� ����");
			
			String query = "delete from t_member where id = ?";
			pstmt =con.prepareStatement(query);
			System.out.println(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("ȸ������ �����ͺ��̽� ���� ����");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
