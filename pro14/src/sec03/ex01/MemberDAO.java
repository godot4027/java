package sec03.ex01;

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
	
	Connection con;
	PreparedStatement pstmt;
	
	DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env/");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * member조회
	 * */
	
	public List membersList () {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from t_member";
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String _id = rs.getString("id");
				String _pwd = rs.getString("pwd");
				String _name = rs.getString("name");
				String _email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberBean vo = new MemberBean();
				vo.setId(_id);
				vo.setPwd(_pwd);
				vo.setName(_name);
				vo.setEmail(_email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	 * member검색
	 * */
	
	public List membersList (MemberBean memberBean) {
		List list = new ArrayList();
		String name = memberBean.getName();
		System.out.println("이름조회 : " + name);
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from t_member";
			if(name != null && name.length() != 0) {
				query += " where name=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);
				
			}else {
				pstmt = con.prepareStatement(query);
			}
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String _id = rs.getString("id");
				String _pwd = rs.getString("pwd");
				String _name = rs.getString("name");
				String _email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberBean vo = new MemberBean();
				vo.setId(_id);
				vo.setPwd(_pwd);
				vo.setName(_name);
				vo.setEmail(_email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	/*
	 * 회원가입
	 * */
	
	public void addMembers(MemberBean memberBean) {
		try {
			con = dataFactory.getConnection();
			
			String _id = memberBean.getId();
			String _pwd= memberBean.getPwd();
			String _name = memberBean.getName();
			String _email = memberBean.getEmail();
			
			System.out.println(_id);
			System.out.println(_pwd);
			System.out.println(_name);
			System.out.println(_email);
			
			
			String query  = "insert into t_member";
			       query += " (id,pwd, name, email)";
			       query += " values(?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, _id);
			pstmt.setString(2, _pwd);
			pstmt.setString(3, _name);
			pstmt.setString(4, _email);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
