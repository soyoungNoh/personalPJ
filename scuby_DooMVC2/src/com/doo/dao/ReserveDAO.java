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
			Class.forName("oracle.jdbc.driver.OracleDriver");	//��θ� ������ ��, ".class"�� ���� �ȵ�
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e)
		{
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e)
		{
			System.out.println("���� ����, ������� ��й�ȣ�� Ȯ���ϼ���");
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


			af = ps.executeUpdate();	//executeUpdate() : DB�� ����� row���� ��ȯ(int)
		} catch (SQLException e)
		{
			System.out.println("�������� ������ ���� �߻�");
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		System.out.println("�������� ���� ����");

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
			rs = ps.executeQuery();	//SELECT�Լ������� ����. 
									//resultset�� DB�� �ִ� �����͸� ������ �ִ´�.(������� �ִ� ������)

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
			System.out.println("���ฮ��Ʈ ��ȸ�� ���� �߻�");
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
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}	
		System.out.println("���ฮ��Ʈ ��ȸ ����");
		
		return rList;
	}
	public Reserve getReserve(String gMid)
	{
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reserve r = null;

		String sql = "SELECT * FROM RESERVE WHERE GMID=?";	 //oracle���� sql���� ���� ���� �غ���, �����ϸ� �����ؿ���
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, gMid);
			rs = ps.executeQuery();	//SELECT ������������ ����. 
									//resultset�� DB�� �ִ� �����͸� ������ �ִ´�.(������� �ִ� ������)
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
			System.out.println("�������� ��ȸ�� ���� �߻�");
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
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}	
		System.out.println("�������� ��ȸ �Ϸ�");
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
		
			af = ps.executeUpdate();	//executeUpdate() : DB�� ����� row���� ��ȯ(int)
		} catch (SQLException e)
		{
			System.out.println("��ȸ�� ������ ���� �߻�");
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		System.out.println("��ȸ�� ���� ����");

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
			

			af = ps.executeUpdate();	//executeUpdate() : DB�� ����� row���� ��ȯ(int)
		} catch (SQLException e)
		{
			System.out.println("�������� ������ ���� �߻�");
			e.printStackTrace();
		}finally
		{
			try
			{
				ps.close();
				con.close();
			} catch (SQLException e)
			{
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		System.out.println("�������� ���� ����. af : "+af);
		
		return af;
	}
}



