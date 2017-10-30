package com.doo.reserve.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.ReserveDAO;
import com.doo.vo.Reserve;

public class ReserveListController implements Controller{
	
	private ReserveDAO rdao;

	public void setRdao(ReserveDAO rdao) {
		this.rdao = rdao;
	}




	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String hMid = (String)session.getAttribute("mid");
		String hitOn = request.getParameter("hitOn");


		ArrayList<Reserve> rList = rdao.getRList(hMid);
		System.out.println("rList.size() : "+rList.size());
		
		if(hitOn !=null && !hitOn.equals("")){
			int af = rdao.hitUp(hMid);
			if(af>0){
				System.out.println("조회수 변경 완료");
			}else{
				System.out.println("조회수 변경 실패");		
			}
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("rList", rList);
		
		mv.setViewName("reserveList.jsp");
		return  mv;

	}

}
