package com.doo.joinus.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//Ŭ���̾�Ʈ�� ��û�� �ޱ� ���ؼ��� ��Ʈ�ѷ��� �����̾�� �� (���� ���)
//web.xml�� ���� ������ ����� ��
public class JoinController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:join.jsp");
		return mv;
	}
}