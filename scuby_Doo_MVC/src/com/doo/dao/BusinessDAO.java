package com.doo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doo.vo.Business;
import com.doo.vo.Member;

public class BusinessDAO {
	
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
	
	public int addBusiness(Business b)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		String sql = "INSERT INTO BUSINESS(DEPT, ADDRESS, MID, NAME, PRICE, INTRO, HIT, REGDATE, FILESRC) VALUES(?,?,?,?,?,?,DEFAULT,DEFAULT,?)";
		con = getConn();

		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getDept());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getMid());
			ps.setString(4, b.getName());
			ps.setInt(5, b.getPrice());
			ps.setString(6, b.getIntro());
			ps.setString(7, b.getFileSrc());

			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("업체정보 저장중 오류 발생");
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
		System.out.println("업체정보 저장 성공");

		return af;
	}
	
	public int updateB(Business b)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "UPDATE BUSINESS SET DEPT=?, ADDRESS=?, NAME=?, INTRO=?, PRICE=? WHERE MID=?";

		con = getConn();
		
		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getDept());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getName());
			ps.setString(4, b.getIntro());
			ps.setInt(5, b.getPrice());
			ps.setString(6, b.getMid());

			

			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("업체정보 수정중 오류 발생");
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
		System.out.println("업제정보 수정 성공");
		
		return af;
	}
	
	public ArrayList<Business> getBList(String dept) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Business b = null;
		ArrayList<Business> bList = null;

		String sql = "SELECT * FROM (SELECT * FROM BUSINESS WHERE DEPT=?) WHERE ROWNUM BETWEEN 1 AND 5";	//oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, dept);	//첫 번째(1) 물음표에, mid를 넣어라.
			bList = new ArrayList<Business>();
			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			while(rs.next())
			{
				b = new Business();
				b.setDept(rs.getString("DEPT"));
				b.setAddress(rs.getString("ADDRESS"));
				b.setMid(rs.getString("MID"));
				b.setName(rs.getString("NAME"));
				b.setIntro(rs.getString("INTRO"));
				b.setHit(rs.getInt("HIT"));
				b.setPrice(rs.getInt("PRICE"));
				b.setFileSrc(rs.getString("FILESRC"));
				b.setRegdate(rs.getString("REGDATE"));
				
				bList.add(b);
			}	
		} catch (SQLException e)
		{
			System.out.println("업체리스트 조회중 오류 발생");
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
		System.out.println("업체리스트 조회 성공");
		
		return bList;
	}
	
	public ArrayList<Business> searchBList(String dept, String address) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Business b = null;
		ArrayList<Business> bList = null;

		String sql = "SELECT * FROM BUSINESS WHERE DEPT=? and ADDRESS LIKE ?";
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, dept);
			ps.setString(2, "%"+address+"%");
			bList = new ArrayList<Business>();
			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			while(rs.next())
			{
				b = new Business();
				b.setDept(rs.getString("DEPT"));
				b.setAddress(rs.getString("ADDRESS"));
				b.setMid(rs.getString("MID"));
				b.setName(rs.getString("NAME"));
				b.setPrice(rs.getInt("PRICE"));
				b.setIntro(rs.getString("INTRO"));
				b.setHit(rs.getInt("HIT"));
				b.setFileSrc(rs.getString("FILESRC"));
				b.setRegdate(rs.getString("REGDATE"));
				
				bList.add(b);
			}	
		} catch (SQLException e)
		{
			System.out.println("업체검색결과 조회중 오류 발생");
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
		System.out.println("업체검색결과 수정 성공");
		
		return bList;
	}

	public Business getBusiness(String mid) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Business b = null;

		String sql = "SELECT * FROM BUSINESS WHERE MID=?";	//oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);	
			rs = ps.executeQuery();	
									

			if(rs.next())
			{
				b = new Business();
				b.setDept(rs.getString("DEPT"));
				b.setAddress(rs.getString("ADDRESS"));
				b.setMid(rs.getString("MID"));
				b.setName(rs.getString("NAME"));
				b.setPrice(rs.getInt("PRICE"));
				b.setIntro(rs.getString("INTRO"));
				b.setHit(rs.getInt("HIT"));
				b.setRegdate(rs.getString("REGDATE"));
				b.setFileSrc(rs.getString("FILESRC"));
			}	
		} catch (SQLException e)
		{
			System.out.println("업체정보 조회중 오류 발생");
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
		System.out.println("업체정보 조회 성공");
		return b;
	}
	
	public int delBusiness(String mid) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "DELETE BUSINESS WHERE MID = ?";
		con = getConn();
		
		try {
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			
			af = af+ps.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("업체 정보 삭제중 오류 발생");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("업체 정보 복구중 오류 발생");
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

	public int hitUp(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		String sql = "UPDATE BUSINESS SET HIT=HIT+1 WHERE MID=?";
		con = getConn();

		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
		
			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("조회수 저장중 오류 발생");
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
		
		System.out.println("조회수 저장 성공");

		return af;	
	}
}
