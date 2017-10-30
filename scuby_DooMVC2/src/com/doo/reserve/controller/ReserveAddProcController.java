package com.doo.reserve.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.MemberDAO;
import com.doo.dao.ReserveDAO;
import com.doo.vo.Member;
import com.doo.vo.Reserve;

public class ReserveAddProcController implements Controller{
	
	private ReserveDAO rdao;
	
	public void setRdao(ReserveDAO rdao) {
		this.rdao = rdao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		String bName  = request.getParameter("bName");
		String bMid  = request.getParameter("bMid");
		
		String kidNum  = request.getParameter("kidNum");
		String adultNum = request.getParameter("adultNum");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String rsvdate = String.format("%s-%s-%s", 2017, month,day);
		String rsvtime = request.getParameter("time");
		String paymth = request.getParameter("payTool");
		String paynum = request.getParameter("cardNum");
		String mm = request.getParameter("mm");
		String yy = request.getParameter("yy");
		String expiredate = String.format("%s/%s", mm,yy);
		String code = request.getParameter("code");
		


		int iAdultNum = Integer.parseInt(adultNum);
		int iKidNum = Integer.parseInt(kidNum);
		int number = iAdultNum+iKidNum;

		
		
		Reserve r = new Reserve(mid,bMid,rsvdate,rsvtime,number,"예약대기",bName,paymth,paynum,expiredate);
		
		ModelAndView mv = new ModelAndView();

		
		int af = rdao.addReserve(r);
		if(af==1)
		{
			System.out.println("예약정보 저장 성공");

			mv.setViewName("redirect:../joinus/loginIndex.do");
			return  mv;
		}else
		{
			System.out.println("예약정보 저장 실패");
			mv.setViewName("redirect:../index.jsp");
			return  mv;
		}
	}

}
