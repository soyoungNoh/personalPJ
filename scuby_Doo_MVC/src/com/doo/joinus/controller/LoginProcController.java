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


//클라이언트의 요청을 받기 위해서는 컨트롤러는 서블릿이어야 함 (서블릿 상속)
//web.xml에 서블릿 매핑을 해줘야 함
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
			System.out.println("아이디가 존재하지 않습니다. 다시 입력하세요.");
			mv.setViewName("login.jsp");
			return mv;

		}else if(pwd.equals(m.getPwd()))
		{
			System.out.println(m.getName()+"님 환영합니다.");
			//response.sendRedirect("welcomejoin.jsp?mid="+mid);

			request.getSession().setAttribute("mid",mid);
			request.getSession().setAttribute("dist",m.getDist());

			
			if(checkIdSave != null && !checkIdSave.equals("")){
				Cookie ck = new Cookie("mid",mid);
				ck.setMaxAge(60*60*24*30); 	//한달동안 쿠키 생존함.
				System.out.println("아이디 저장 쿠키 생성");
				response.addCookie(ck);
			}else{
				Cookie ck = new Cookie("mid",mid);
				ck.setMaxAge(0); 	//쿠키 0초동안 생존 = 삭제
				System.out.println("쿠키 삭제");
				response.addCookie(ck);		
			}

			if(checkLoginSave != null && !checkLoginSave.equals("")){
				Cookie ck2 = new Cookie("mid",mid);
				Cookie ck3 = new Cookie("pwd",pwd);
				ck2.setMaxAge(60*60*24*30); 	//한달동안 쿠키 생존함.
				ck3.setMaxAge(60*60*24*30); 
				System.out.println("로그인유지 쿠키 생성");
				response.addCookie(ck2);
				response.addCookie(ck3);
			}else{
				Cookie ck2 = new Cookie("mid",mid);
				Cookie ck3 = new Cookie("pwd",pwd);
				ck2.setMaxAge(0); 	//한달동안 쿠키 생존함.
				ck3.setMaxAge(0); 
				System.out.println("쿠키 삭제");
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
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("다시 입력하세요.");

			mv.setViewName("login.jsp");
			return mv;
		}	
	}
}