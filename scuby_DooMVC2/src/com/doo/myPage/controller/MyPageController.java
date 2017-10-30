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
import com.doo.vo.Business;
import com.doo.vo.Member;

public class MyPageController implements Controller
{
	
	private MemberDAO mdao;
	private BusinessDAO bdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		Member m = mdao.getMember(mid);
		
		Business b = bdao.getBusiness(mid);
		
		ModelAndView mv = new ModelAndView();
		
		
		if(m.getDist().equals("È£½ºÆ®")){
			session.setAttribute("mid", mid);
			request.setAttribute("m", m);
			request.setAttribute("b", b);
			//if(b.getName().equals(null)){}
			
			mv.setViewName("myPageHost.jsp");
			return mv;
			
		}else {
			session.setAttribute("mid", mid);
			request.setAttribute("m", m);
			mv.setViewName("myPageGuest.jsp");	
			return mv;
		}
	
	}

}
