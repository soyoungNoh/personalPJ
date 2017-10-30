package com.doo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doo.vo.Member;


public class MemberDAO {
	
	public Connection getConn()
	{
		String url="jdbc:oracle:thin:@211.238.142.124:1521:orcl";
		String user="soyoung";
		String pwd="1234";

		Connection con = null;

		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//경로명 가져올 때, ".class"는 들어가면 안됨
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e)
		{
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.out.println("접속 실패, 계정명과 비밀번호를 확인하세요");
			e.printStackTrace();
		}

		return con;	
	}
	
	public Member getMember(String mid)
	{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;

		String sql = "SELECT * FROM MEMBER WHERE MID=?";	//oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);	//첫 번째(1) 물음표에, mid를 넣어라.
			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			if(rs.next())
			{
				m = new Member();
				m.setMid(rs.getString("MID"));
				m.setPwd(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
				m.setGender(rs.getString("GENDER"));
				m.setAge(rs.getInt("AGE"));
				m.setBirthday(rs.getString("BIRTHDAY"));
				m.setPhone(rs.getString("PHONE"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setEmail(rs.getString("EMAIL"));
				m.setProper(rs.getString("PROPER"));
				m.setState(rs.getString("STATE"));
				m.setRegdate(rs.getString("REGDATE"));
				m.setDist(rs.getString("DIST"));
				System.out.println("내보내는 중");
			}	
		} catch (SQLException e)
		{
			System.out.println("회원정보 조회중 오류 발생");
			e.printStackTrace();
		}finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}	
		System.out.println("내보내기 성공");

		return m;	
	}
	
	public int addMember(Member m)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		String sql = "INSERT INTO MEMBER(MID, PWD, NAME, GENDER, AGE, BIRTHDAY, PHONE, ADDRESS, EMAIL, PROPER, STATE, REGDATE, DIST) VALUES(?,?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT,?)";
		con = getConn();

		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getGender());
			ps.setInt(5, m.getAge());
			ps.setString(6, m.getBirthday());
			ps.setString(7, m.getPhone());
			ps.setString(8, m.getAddress());
			ps.setString(9, m.getEmail());
			ps.setString(10, m.getProper());
			ps.setString(11, m.getDist());
			

			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("회원정보 저장중 오류 발생");
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		System.out.println("회원정보 저장 성공");

		return af;
	}
	
	public int updateMember(Member m)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "UPDATE MEMBER SET PWD=?, AGE=?, BIRTHDAY=?, ADDRESS=?, PHONE=?, EMAIL=?, PROPER=? WHERE MID=?";

		con = getConn();
		
		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setInt(2, m.getAge());
			ps.setString(3, m.getBirthday());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getEmail());
			ps.setString(7, m.getProper());
			ps.setString(8, m.getMid());
			

			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("회원정보 수정중 오류 발생");
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		System.out.println("회원정보 수정 성공. af : "+af);
		
		return af;
	}

	public ArrayList<Member> getGMembers() {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		ArrayList<Member> gList = null;

		String sql = "SELECT * FROM MEMBER WHERE DIST=?";	//oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, "게스트");	//첫 번째(1) 물음표에, mid를 넣어라.
			gList = new ArrayList<Member>();
			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			while(rs.next())
			{
				m = new Member();
				m.setMid(rs.getString("MID"));
				m.setPwd(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
				m.setGender(rs.getString("GENDER"));
				m.setAge(rs.getInt("AGE"));
				m.setBirthday(rs.getString("BIRTHDAY"));
				m.setPhone(rs.getString("PHONE"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setEmail(rs.getString("EMAIL"));
				m.setProper(rs.getString("PROPER"));
				m.setState(rs.getString("STATE"));
				m.setRegdate(rs.getString("REGDATE"));
				m.setDist(rs.getString("DIST"));
				
				gList.add(m);
			}	
		} catch (SQLException e)
		{
			System.out.println("게스트정보 조회중 오류 발생");
			e.printStackTrace();
		}finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}	
		return gList;
	}
	
	public ArrayList<Member> getHMembers() {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		ArrayList<Member> hList = null;

		String sql = "SELECT * FROM MEMBER WHERE DIST=?";	//oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, "호스트");
			hList = new ArrayList<Member>();

			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			while(rs.next())
			{
				m = new Member();
				m.setMid(rs.getString("MID"));
				m.setPwd(rs.getString("PWD"));
				m.setName(rs.getString("NAME"));
				m.setGender(rs.getString("GENDER"));
				m.setAge(rs.getInt("AGE"));
				m.setBirthday(rs.getString("BIRTHDAY"));
				m.setPhone(rs.getString("PHONE"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setEmail(rs.getString("EMAIL"));
				m.setProper(rs.getString("PROPER"));
				m.setState(rs.getString("STATE"));
				m.setRegdate(rs.getString("REGDATE"));
				m.setDist(rs.getString("DIST"));
				
				hList.add(m);
			}	
		} catch (SQLException e)
		{
			System.out.println("게스트정보 조회중 오류 발생");
			e.printStackTrace();
		}finally
		{
			try
			{
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}	
		return hList;
	}

	public int delMember(String mid) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "DELETE MEMBER WHERE MID = ?";
		con = getConn();
		
		try {
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			
			af = af+ps.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("회원 정보 삭제중 오류 발생");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("회원 정보 복구중 오류 발생");
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally{
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제 실패");
				e.printStackTrace();
			}
			
		}
		return af;
	}

}
