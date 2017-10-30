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

public class DelMemProcController implements Controller{
	
	private MemberDAO mdao;
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		Member m = mdao.getMember(mid);
		int af = mdao.delMember(mid);
		
		ModelAndView mv = new ModelAndView();

		if(af>=1){
			System.out.println("회원 삭제에 성공하였습니다.");
			mv.setViewName("redirect:../index.jsp");
			
			return mv;

		}else{
			System.out.println("회원 삭제에 실패하였습니다.");
			mv.setViewName("redirect:../index.jsp");

			return mv;
		}
	}
}
