package com.doo.host.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.vo.Business;

public class BusinessDetailController implements Controller {

	private BusinessDAO bdao;
	
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = request.getParameter("mid");
		String hitOn = request.getParameter("hitOn");
		
		int af=0;
		
		Business b = new Business();
		
		b = bdao.getBusiness(mid);
		
		if(hitOn !=null && !hitOn.equals("")){
			af = bdao.hitUp(mid);
			if(af>0){
				System.out.println("조회수 변경 완료");
			}else{
				System.out.println("조회수 변경 실패");		
			}
		}			
		
		ModelAndView mv = new ModelAndView();

		
		mv.addObject("b", b);
		
		mv.setViewName("businessDetail.jsp");
		return mv;

	}

}
