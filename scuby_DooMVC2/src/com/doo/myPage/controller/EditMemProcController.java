package com.doo.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.dao.MemberDAO;
import com.doo.vo.Member;

public class EditMemProcController implements Controller{

	private MemberDAO mdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String pwd = request.getParameter("pwd");
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

		int iage = Integer.parseInt(age);
		String properties = "";
		
		for(int i=0;i<proper.length;i++)
		{
			if(properties=="")
				properties=proper[i];
			else
				properties=properties+','+proper[i];	
		}
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");

		Member m = mdao.getMember(mid);;
		
		System.out.println("getMid : "+ m.getMid());

		m.setPwd(pwd);
		m.setGender(gender);
		m.setAge(iage);
		m.setBirthday(birthday);
		m.setPhone(phone);
		m.setAddress(address);
		m.setEmail(email);
		m.setProper(properties);
		
		int af = mdao.updateMember(m);
		
		ModelAndView mv = new ModelAndView();


		if (af == 1) {
			System.out.println("회원수정 성공");
			
			mv.setViewName("redirect:../joinus/loginIndex.jsp");
			return mv;
			
		} else {
			System.out.println("회원수정 실패");
			return null;
		}
	}

}
