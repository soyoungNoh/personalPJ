package com.doo.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.MemberDAO;
import com.doo.vo.Member;

public class BusinessAddController implements Controller{
	

	private MemberDAO mdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
		
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		session.setAttribute("mid", mid);
		
		Member m = mdao.getMember(mid);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("m", m);
		
		mv.setViewName("businessAdd.jsp");
		return mv;		
		
	}

}
