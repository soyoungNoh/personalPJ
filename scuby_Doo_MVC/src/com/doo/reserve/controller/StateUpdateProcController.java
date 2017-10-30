package com.doo.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.ReserveDAO;
import com.doo.vo.Reserve;

public class StateUpdateProcController implements Controller{
	
	private ReserveDAO rdao;
	
	public void setRdao(ReserveDAO rdao) {
		this.rdao = rdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String gMid = request.getParameter("gMid");

		System.out.println("gMid : "+gMid);

		Reserve r = rdao.getReserve(gMid);
		
		System.out.println(r.getState());
		r.setState("����Ȯ��");

		int af = rdao.updateRsv(r);
		
		ModelAndView mv = new ModelAndView();

		if (af == 1) {
			System.out.println("������������ ���� ����");
		} else {
			System.out.println("������������ ����  ����");
			return null;
		}
		
		mv.setViewName("redirect:../reserveList.do");
		return  mv;
	
	}

}
