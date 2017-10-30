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
		
		
		ArrayList<Business> Alist = bdao.getBList("��������̺�");
		ArrayList<Business> Blist = bdao.getBList("�������շ���");
		ArrayList<Business> Clist = bdao.getBList("����");
		ArrayList<Business> Dlist = bdao.getBList("����Ű");
		ArrayList<Business> Elist = bdao.getBList("����ũ����");
		ArrayList<Business> Flist = bdao.getBList("�������");
			
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
