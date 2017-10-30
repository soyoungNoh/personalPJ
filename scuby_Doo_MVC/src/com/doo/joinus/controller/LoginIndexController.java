package com.doo.joinus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.vo.Business;


public class LoginIndexController implements Controller{

	private BusinessDAO bdao;
	

	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ModelAndView mv = new ModelAndView();
		
		
		ArrayList<Business> Alist = bdao.getBList("스쿠버다이빙");
		ArrayList<Business> Blist = bdao.getBList("수상종합레저");
		ArrayList<Business> Clist = bdao.getBList("서핑");
		ArrayList<Business> Dlist = bdao.getBList("수상스키");
		ArrayList<Business> Elist = bdao.getBList("웨이크보드");
		ArrayList<Business> Flist = bdao.getBList("블롭점프");
			
		String hitOn = "on";
		
		mv.addObject("Alist", Alist);
		mv.addObject("Blist", Blist);
		mv.addObject("Clist", Clist);
		mv.addObject("Dlist", Dlist);
		mv.addObject("Elist", Elist);
		mv.addObject("Flist", Flist);
		mv.addObject("hitOn", hitOn);
		
		
		mv.setViewName("loginIndex.jsp");
		return mv;
		
	}

}
