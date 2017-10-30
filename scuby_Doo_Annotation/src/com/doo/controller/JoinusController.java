package com.doo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doo.dao.MemberDAO;
import com.doo.joinus.controller.ModelAndView;
import com.doo.util.CookieManager;
import com.doo.vo.Member;

@Controller
public class JoinusController {
	
	@Autowired
	MemberDAO mdao;
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@RequestMapping("/joinus/login.do")
	public String login(HttpServletRequest request, Model model){

		Cookie[] coos = request.getCookies();

		String cookieMid = CookieManager.getCookie(coos,"mid");
		String cookiePwd = CookieManager.getCookie(coos,"pwd");


		System.out.println("cookieMid : "+cookieMid);
		System.out.println("cookiePwd : "+cookiePwd);

		if(cookieMid != null && cookieMid != "" && cookiePwd != null && cookiePwd != "")
		{
			return "redirect:loginProc.do?mid="+cookieMid+"&pwd="+cookiePwd;
		}else
		{
			if(cookieMid != null && cookieMid != ""){
				model.addAttribute("cookieMid", cookieMid);
			}	
			if(cookiePwd != null && cookiePwd != ""){
				model.addAttribute("cookiePwd", cookiePwd);
			}
			return "login.jsp";
		}
		
	}
	
	@RequestMapping("/joinus/loginProc.do")
	public String loginProc(HttpServletRequest request, HttpServletResponse response, String pwd, String mid, String checkIdSave,String checkLoginSave){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();

		Member m = mdao.getMember(mid);
		

		if(m==null)
		{
			System.out.println("���̵� �������� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			return "login.jsp";

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
				
				return "redirect:"+returnURL;
			}
			
			return "redirect:loginIndex.do";
			
		}else
		{
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			System.out.println("�ٽ� �Է��ϼ���.");

			mv.setViewName("login.jsp");
			return mv;
		}	
		
	}

}