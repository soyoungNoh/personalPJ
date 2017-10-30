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

			af = ps.executeUpdate();	//executeUpdate() : DB�� ����� row���� ��ȯ(int)
		} catch (SQLException e)
		{
			System.out.println("��ü���� ������ ���� �߻�");
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
		System.out.println("��ü���� ���� ����");

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

			

			af = ps.executeUpdate();	//executeUpdate() : DB�� ����� row���� ��ȯ(int)
		} catch (SQLException e)
		{
			System.out.println("��ü���� ������ ���� �߻�");
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
	
	public ArrayList<Business> getBList(String dept) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Business b = null;
		ArrayList<Business> bList = null;

		String sql = "SELECT * FROM (SELECT * FROM BUSINESS WHERE DEPT=?) WHERE ROWNUM BETWEEN 1 AND 5";	//oracle���� sql���� ���� ���� �غ���, �����ϸ� �����ؿ���
		con = getConn();
		
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, dept);	//ù ��°(1) ����ǥ��, mid�� �־��.
			bList = new ArrayList<Business>();
			rs = ps.executeQuery();	//SELECT�Լ������� ����. 
									//resultset�� DB�� �ִ� �����͸� ������ �ִ´�.(������� �ִ� ������)

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
			System.out.println("��ü����Ʈ ��ȸ�� ���� �߻�");
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
		System.out.println("��ü����Ʈ ��ȸ ����");
		
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
			rs = ps.executeQuery();	//SELECT�Լ������� ����. 
									//resultset�� DB�� �ִ� �����͸� ������ �ִ´�.(������� �ִ� ������)

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
			System.out.println("��ü�˻���� ��ȸ�� ���� �߻�");
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
		System.out.println("��ü�˻���� ���� ����");
		
		return bList;
	}

	public Business getBusiness(String mid) {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Business b = null;

		String sql = "SELECT * FROM BUSINESS WHERE MID=?";	//oracle���� sql���� ���� ���� �غ���, �����ϸ� �����ؿ���
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
			System.out.println("��ü���� ��ȸ�� ���� �߻�");
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
		System.out.println("��ü���� ��ȸ ����");
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
			System.out.println("��ü ���� ������ ���� �߻�");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("��ü ���� ������ ���� �߻�");
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally{
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("���� ���� ����");
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
}
