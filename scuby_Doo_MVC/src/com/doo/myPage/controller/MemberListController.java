package com.doo.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.MemberDAO;
import com.doo.vo.Member;

public class MemberListController implements Controller{
	
	private MemberDAO mdao;
	
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Member> gList = new ArrayList();
		ArrayList<Member> hList = new ArrayList();
		

		gList = mdao.getGMembers();
		hList = mdao.getHMembers();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("gList", gList);
		mv.addObject("hList", hList);
		
		mv.setViewName("memberList.jsp");
		return mv;
	}

}
