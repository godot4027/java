package sec04.ex02;

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
	
	public MemberDAO() {
		try {
			
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env/");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * 회원정보 조회
	 * */
	List<MemberVO> memberJoin(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = dataFactory.getConnection();
			
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
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	
	
	/*
	 * 
	 * 회원등록
	 */
	
	public void addMember(MemberVO memberVO) {
		try{
			con = dataFactory.getConnection();
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += "(id, pwd, name, email)";
			query += "values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			System.out.println(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);	
			pstmt.executeUpdate();
			
			
			pstmt.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * 회원탈퇴
	 * */
	
	public void delMember(String id) {
		
		try {
			con = dataFactory.getConnection();
			
			String query = "delete from t_member where id = ?";
			pstmt = con.prepareStatement(query);
			System.out.println(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
