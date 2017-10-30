package com.doo.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.vo.Business;


public class BusinessDelProcController implements Controller {

	private BusinessDAO bdao;
	
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		

		int af = bdao.delBusiness(mid);
		
		ModelAndView mv = new ModelAndView();

		
		if(af>=1){
			System.out.println("업체 삭제에 성공하였습니다.");
			
			mv.setViewName("redirect:../myPage/myPage.do");
			return mv;

		}else{
			System.out.println("업체 삭제에 실패하였습니다.");
			mv.setViewName("redirect:../myPage/myPage.do");
			return mv;
		}
	}

}
