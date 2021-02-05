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
	 * 회원정보 조회하기
	 * */
	
	List<MemberVO> memberJoin () {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 데이터베이스 연결			
			con = dataFactory.getConnection();
			System.out.println("회원조회 데이터베이스 연결성공");
			
			// 쿼리 작동
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
			
			System.out.println("회원조회 데이터베이스 연결해제");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	
	/*
	 * 회원가입
	 * */
	
	public void addMember(MemberVO memberVO) {
		try {
			//데이터베이스 연결
		
			con = dataFactory.getConnection();
			System.out.println("회원가입 데이터베이스 연결 성공");
			
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
			System.out.println("회원가입 데이터베이스 연결 해제");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 회원삭제 
	 * */
	
	public void delMember(String id) {
		try{
			con = dataFactory.getConnection();
			System.out.println("회원삭제 데이터베이스 연결 성공");
			
			String query = "delete from t_member where id = ?";
			pstmt =con.prepareStatement(query);
			System.out.println(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			System.out.println("회원삭제 데이터베이스 연결 해제");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
