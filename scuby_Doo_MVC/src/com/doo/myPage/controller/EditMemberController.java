package com.doo.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.MemberDAO;
import com.doo.vo.Member;

public class EditMemberController implements Controller{
	
	private MemberDAO mdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member m = new Member();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		m = mdao.getMember(mid);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("m", m);
		
		mv.setViewName("editMember.jsp");
		return mv;
	
	}

}
