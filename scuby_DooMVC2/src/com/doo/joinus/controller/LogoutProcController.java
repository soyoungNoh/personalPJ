package com.doo.joinus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LogoutProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		ModelAndView mv = new ModelAndView();

		session.invalidate();
		
		Cookie ck2 = new Cookie("mid",mid);
		
		mv.setViewName("index.jsp");
		return mv;
	}

}
