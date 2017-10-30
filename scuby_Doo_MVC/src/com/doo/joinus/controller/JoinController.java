package com.doo.joinus.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//클라이언트의 요청을 받기 위해서는 컨트롤러는 서블릿이어야 함 (서블릿 상속)
//web.xml에 서블릿 매핑을 해줘야 함
public class JoinController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:join.jsp");
		return mv;
	}
}