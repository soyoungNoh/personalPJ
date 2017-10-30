package com.doo.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.dao.MemberDAO;
import com.doo.dao.ReserveDAO;
import com.doo.vo.Business;
import com.doo.vo.Member;

public class ReservePageController implements Controller{

	private BusinessDAO bdao;
	private MemberDAO mdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String guestMid = (String)session.getAttribute("bmid");
		
		String hostMid = request.getParameter("mid");

		
		Business b = bdao.getBusiness(hostMid);
		Member g = mdao.getMember(guestMid);
		Member m = mdao.getMember(hostMid);

		ModelAndView mv = new ModelAndView();
		mv.addObject("b", b);
		mv.addObject("g", g);
		mv.addObject("m", m);

		
		mv.setViewName("reservePage.jsp");
		return  mv;
	}

}
