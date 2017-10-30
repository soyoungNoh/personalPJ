package com.doo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doo.vo.Business;
import com.doo.vo.Member;
import com.doo.vo.Reserve;

public class ReserveDAO {
	
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
	
	public int addReserve(Reserve r)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		String sql = "INSERT INTO RESERVE VALUES((SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM RESERVE),?,?,?,?,?,DEFAULT,?,?,?,?,DEFAULT,?)";

		con = getConn();

		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, r.getGMid());
			ps.setString(2, r.getRsvDate());
			ps.setString(3, r.getRsvTime());
			ps.setInt(4, r.getNumber());
			ps.setString(5, r.getState());
			ps.setString(6, r.getBname());
			ps.setString(7, r.getPaymth());
			ps.setString(8, r.getPaynum());
			ps.setString(9, r.getExpiredate());
			ps.setString(10, r.gethMid());


			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("예약정보 저장중 오류 발생");
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
		System.out.println("예약정보 저장 성공");

		return af;
	}
	
	public ArrayList<Reserve> getRList(String hMid) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reserve r = null;
		ArrayList<Reserve> rList = null;

		String sql = "SELECT * FROM (SELECT ROWNUM RN, N.* FROM(SELECT * FROM RESERVE WHERE HMID LIKE ? ORDER BY TO_NUMBER(SEQ) DESC) N) WHERE RN BETWEEN 1 AND 10";
		con = getConn();
		
		try
		{
			rList = new ArrayList<Reserve>();
			ps = con.prepareStatement(sql);
			ps.setString(1, hMid);
			rs = ps.executeQuery();	//SELECT함수에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)

			while(rs.next())
			{
				r = new Reserve();
				r.setSeq(rs.getInt("RN"));
				r.setGMid(rs.getString("GMID"));
				r.setRsvDate(rs.getString("RSVDATE"));
				r.setRsvtime(rs.getString("RSVTIME"));
				r.setNumber(rs.getInt("NUMBER"));
				r.setState(rs.getString("STATE"));
				r.setRegdate(rs.getString("REGDATE"));
				r.setBname(rs.getString("BNAME"));
				r.setPaymth(rs.getString("PAYMTH"));
				r.setPaynum(rs.getString("PAYNUM"));
				r.setExpiredate(rs.getString("EXPIREDATE"));
				r.setHit(rs.getInt("HIT"));
				r.sethMid(rs.getString("HMID"));

				
				rList.add(r);
			}	
		} catch (SQLException e)
		{
			System.out.println("예약리스트 조회중 오류 발생");
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
		System.out.println("예약리스트 조회 성공");
		
		return rList;
	}
	public Reserve getReserve(String gMid)
	{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reserve r = null;

		String sql = "SELECT * FROM RESERVE WHERE GMID=?";	 //oracle에서 sql문장 실행 먼저 해보고, 완전하면 복붙해오기
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, gMid);
			rs = ps.executeQuery();	//SELECT 쿼리문에서만 쓴다. 
									//resultset이 DB에 있는 데이터를 가져와 넣는다.(결과물이 있는 쿼리문)
			if(rs.next())
			{
				r = new Reserve();
				r.setSeq(rs.getInt("SEQ"));
				r.setGMid(rs.getString("GMID"));
				r.setRsvDate(rs.getString("RSVDATE"));
				r.setRsvtime(rs.getString("RSVTIME"));
				r.setState(rs.getString("STATE"));
				r.setRegdate(rs.getString("REGDATE"));
				r.setBname(rs.getString("BNAME"));
				r.setPaymth(rs.getString("PAYMTH"));
				r.setPaynum(rs.getString("PAYNUM"));
				r.setExpiredate(rs.getString("EXPIREDATE"));
				r.setHit(rs.getInt("HIT"));
				r.sethMid(rs.getString("HMID"));
			}	
		} catch (SQLException e)
		{
			System.out.println("예약정보 조회중 오류 발생");
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
		System.out.println("예약정보 조회 완료");
		return r;	
	}

	public int hitUp(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		String sql = "UPDATE RESERVE SET HIT=HIT+1 WHERE HMID=?";
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
	public int updateRsv(Reserve r)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "UPDATE RESERVE SET RSVDATE=?, RSVTIME=?, STATE=?, \"NUMBER\"=?, REGDATE=?, PAYMTH=?, PAYNUM=?, EXPIREDATE=? WHERE SEQ=?";

		con = getConn();
		
		try
		{	
			ps = con.prepareStatement(sql);
			ps.setString(1, r.getRsvDate());
			ps.setString(2, r.getRsvTime());
			ps.setString(3, r.getState());
			ps.setInt(4, r.getNumber());
			ps.setString(5, r.getRegdate());
			ps.setString(6, r.getPaymth());
			ps.setString(7, r.getPaynum());
			ps.setString(8, r.getExpiredate());
			ps.setInt(9, r.getSeq());
			

			af = ps.executeUpdate();	//executeUpdate() : DB에 변경된 row갯수 반환(int)
		} catch (SQLException e)
		{
			System.out.println("예약정보 수정중 오류 발생");
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
		System.out.println("예약정보 수정 성공. af : "+af);
		
		return af;
	}
}



