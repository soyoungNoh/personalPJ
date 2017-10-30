package com.doo.joinus.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
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
public class JoinProcController implements Controller{
	
	private MemberDAO mdao;

	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ServletContextA = request.getServletContext().getInitParameter("context-param-test");
		System.out.println("ServletContextA : "+ ServletContextA);

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birthday = String.format("%s-%s-%s", year, month,day);
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String[] proper = request.getParameterValues("proper");
		String dist = request.getParameter("dist");

		int iage = Integer.parseInt(age);
		String properties = "";
		
		for(int i=0;i<proper.length;i++)
		{
			if(properties=="")
				properties=proper[i];
			else
				properties=properties+','+proper[i];	
		}
		
		Member m = new Member();
		m.setMid(mid);
		m.setPwd(pwd);
		m.setName(name);
		m.setGender(gender);
		m.setAge(iage);
		m.setBirthday(birthday);
		m.setPhone(phone);
		m.setAddress(address);
		m.setEmail(email);
		m.setProper(properties);
		m.setDist(dist);
		
		int af = mdao.addMember(m);
		
		ModelAndView mv = new ModelAndView();
		if(af==1)
		{
			System.out.println("회원정보 수정 성공");
			//response.sendRedirect("login.do");
			mv.setViewName("redirect:../index.jsp");
			return mv;
		}else
		{
			System.out.println("회원정보 수정 실패");
			//response.sendRedirect("login.do");
			mv.setViewName("redirect:../index.jsp");
			return mv;
		}
	}
}