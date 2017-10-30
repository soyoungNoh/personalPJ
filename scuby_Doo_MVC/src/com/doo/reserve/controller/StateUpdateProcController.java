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
		r.setState("예약확정");

		int af = rdao.updateRsv(r);
		
		ModelAndView mv = new ModelAndView();

		if (af == 1) {
			System.out.println("예약접수상태 수정 성공");
		} else {
			System.out.println("예약접수상태 수정  실패");
			return null;
		}
		
		mv.setViewName("redirect:../reserveList.do");
		return  mv;
	
	}

}
