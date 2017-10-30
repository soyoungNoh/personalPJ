package com.doo.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doo.dao.BusinessDAO;
import com.doo.dao.MemberDAO;
import com.doo.dao.ReserveDAO;
import com.doo.vo.Business;
import com.doo.vo.Member;
import com.doo.vo.Reserve;

@Controller
public class ReserveController {
	
	private ReserveDAO rdao;
	private BusinessDAO bdao;
	private MemberDAO mdao;
	
	@Autowired
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@Autowired
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}

	@Autowired
	public void setRdao(ReserveDAO rdao) {
		this.rdao = rdao;
	}

	@RequestMapping("/reserve/rsvList.do")
	public String rsvList(HttpServletRequest request, Model model, String hitOn){
		
		HttpSession session = request.getSession();
		String hMid = (String)session.getAttribute("mid");

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
		
		model.addAttribute("rList", rList);
		
		return "reserveList.jsp";
	}
	
	@RequestMapping("/reserve/rsvPage.do")	
	public String rsvPage(HttpServletRequest request,String mid, Model model){

		HttpSession session = request.getSession();
		String guestMid = (String)session.getAttribute("bmid");
		
		Business b = bdao.getBusiness(mid);
		Member g = mdao.getMember(guestMid);
		Member m = mdao.getMember(mid);

		model.addAttribute("b", b);
		model.addAttribute("g", g);
		model.addAttribute("m", m);
		
		return "reservePage.jsp";
	}
	
	@RequestMapping("/reserve/rsvAddProc.do")	
	public String rsvAddProc(HttpServletRequest request,String bName, String bMid, String kidNum, String adultNum, String rsvdate,
				String time,String payTool, String cardNum, String expiredate, String code){
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");

		int iAdultNum = Integer.parseInt(adultNum);
		int iKidNum = Integer.parseInt(kidNum);
		int number = iAdultNum+iKidNum;
		
		Reserve r = new Reserve(mid,bMid,rsvdate,time,number,"예약대기",bName,payTool,cardNum,expiredate);
	
		int af = rdao.addReserve(r);
		if(af==1)
		{
			System.out.println("예약정보 저장 성공");

			return  "redirect:../joinus/loginIndex.do";
		}else
		{
			System.out.println("예약정보 저장 실패");
			return  "redirect:../index.jsp";
		}
	}
	
	@RequestMapping("/reserve/stateUpdateProc.do")
	public String stateUpdateProc(String gMid){
		
		System.out.println("gMid : "+gMid);

		Reserve r = rdao.getReserve(gMid);
		
		System.out.println(r.getState());
		r.setState("예약확정");

		int af = rdao.updateRsv(r);
		

		if (af == 1) {
			System.out.println("예약접수상태 수정 성공");
		} else {
			System.out.println("예약접수상태 수정  실패");
			return null;
		}
		
		return  "redirect:../reserveList.do";
	}

}
