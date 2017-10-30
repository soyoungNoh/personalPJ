package com.doo.joinus.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.MemberDAO;
import com.doo.vo.Member;


//Ŭ���̾�Ʈ�� ��û�� �ޱ� ���ؼ��� ��Ʈ�ѷ��� �����̾�� �� (���� ���)
//web.xml�� ���� ������ ����� ��
public class LoginProcController implements Controller{
	
	private MemberDAO mdao;
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		
		String pwd = request.getParameter("pwd");
		String mid = request.getParameter("mid");  
		String checkIdSave = request.getParameter("checkIdSave");
		String checkLoginSave = request.getParameter("checkLoginSave");

		Member m = mdao.getMember(mid);
		
		ModelAndView mv = new ModelAndView();

		if(m==null)
		{
			System.out.println("���̵� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			mv.setViewName("login.jsp");
			return mv;

		}else if(pwd.equals(m.getPwd()))
		{
			System.out.println(m.getName()+"�� ȯ���մϴ�.");
			//response.sendRedirect("welcomejoin.jsp?mid="+mid);

			request.getSession().setAttribute("mid",mid);
			request.getSession().setAttribute("dist",m.getDist());

			
			if(checkIdSave != null && !checkIdSave.equals("")){
				Cookie ck = new Cookie("mid",mid);
				ck.setMaxAge(60*60*24*30); 	//�Ѵ޵��� ��Ű ������.
				System.out.println("���̵� ���� ��Ű ����");
				response.addCookie(ck);
			}else{
				Cookie ck = new Cookie("mid",mid);
				ck.setMaxAge(0); 	//��Ű 0�ʵ��� ���� = ����
				System.out.println("��Ű ����");
				response.addCookie(ck);		
			}

			if(checkLoginSave != null && !checkLoginSave.equals("")){
				Cookie ck2 = new Cookie("mid",mid);
				Cookie ck3 = new Cookie("pwd",pwd);
				ck2.setMaxAge(60*60*24*30); 	//�Ѵ޵��� ��Ű ������.
				ck3.setMaxAge(60*60*24*30); 
				System.out.println("�α������� ��Ű ����");
				response.addCookie(ck2);
				response.addCookie(ck3);
			}else{
				Cookie ck2 = new Cookie("mid",mid);
				Cookie ck3 = new Cookie("pwd",pwd);
				ck2.setMaxAge(0); 	//�Ѵ޵��� ��Ű ������.
				ck3.setMaxAge(0); 
				System.out.println("��Ű ����");
				response.addCookie(ck2);
				response.addCookie(ck3);	
			}

			String returnURL = (String)request.getSession().getAttribute("returnURL");
			
			if(returnURL != null && returnURL.equals(""))
			{
				String contextRootName = request.getContextPath();
				System.out.println("contextRootName = "+contextRootName);
				
				mv.setViewName("redirect:"+returnURL);
				return mv;
			}
			
			mv.setViewName("redirect:loginIndex.do");
			return mv;
			
		}else
		{
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			System.out.println("�ٽ� �Է��ϼ���.");

			mv.setViewName("login.jsp");
			return mv;
		}	
	}
}