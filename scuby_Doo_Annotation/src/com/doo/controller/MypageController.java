package com.doo.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doo.dao.BusinessDAO;
import com.doo.dao.MemberDAO;
import com.doo.vo.Business;
import com.doo.vo.Member;

@Controller
public class MypageController {
	
	private MemberDAO mdao;
	private BusinessDAO bdao;

	
	@Autowired
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	@Autowired
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}


	@RequestMapping("/myPage/memberList.do")
	public String memberList(Model model){
		
		ArrayList<Member> gList = new ArrayList();
		ArrayList<Member> hList = new ArrayList();
		

		gList = mdao.getGMembers();
		hList = mdao.getHMembers();
		
		
		model.addAttribute("gList", gList);
		model.addAttribute("hList", hList);
		
		return "memberList.jsp";
	}
	
	@RequestMapping("/myPage/myPage.do")
	public String myPage(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		Member m = mdao.getMember(mid);
		
		Business b = bdao.getBusiness(mid);
		
		if(m.getDist().equals("호스트")){
			session.setAttribute("mid", mid);
			model.addAttribute("m", m);
			model.addAttribute("b", b);
			//if(b.getName().equals(null)){}
			
			return "myPageHost.jsp";
			
		}else {
			session.setAttribute("mid", mid);
			model.addAttribute("m", m);
			return "myPageGuest.jsp";
		}
		
	}
	
	@RequestMapping("/myPage/delMemProc.do")
	public String delMemProc(HttpServletRequest request){
	
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		Member m = mdao.getMember(mid);
		
		int af = mdao.delMember(mid);
		

		if(af>=1){
			System.out.println("회원 삭제에 성공하였습니다.");
			return "redirect:../index.jsp";

		}else{
			System.out.println("회원 삭제에 실패하였습니다.");
			return "redirect:../index.jsp";
		}
	}
	
	@RequestMapping("/myPage/delMem.do")
	public String delMem(){
		return "delMem.jsp";
	}
	
	@RequestMapping("/myPage/editMember.do")
	public String editMember(HttpServletRequest request, Model model){
		Member m = new Member();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		m = mdao.getMember(mid);
		
		model.addAttribute("m", m);
		
		return "editMember.jsp";
	}
	
	@RequestMapping("/myPage/editMemProc.do")
	public String editMemProc(HttpServletRequest request,String pwd, String gender, String age, String phone, String address,String email,String birthday,String[] proper) throws UnsupportedEncodingException{
		
		request.setCharacterEncoding("UTF-8");

		int iage = Integer.parseInt(age);
		String properties = "";
		
		for(int i=0;i<proper.length;i++)
		{
			if(properties=="")
				properties=proper[i];
			else
				properties=properties+','+proper[i];	
		}
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");

		Member m = mdao.getMember(mid);;
		
		System.out.println("getMid : "+ m.getMid());

		m.setPwd(pwd);
		m.setGender(gender);
		m.setAge(iage);
		m.setBirthday(birthday);
		m.setPhone(phone);
		m.setAddress(address);
		m.setEmail(email);
		m.setProper(properties);
		
		int af = mdao.updateMember(m);
		
		if (af == 1) {
			System.out.println("회원수정 성공");
			
			return "redirect:../joinus/loginIndex.jsp";
			
		} else {
			System.out.println("회원수정 실패");
			return null;
		}
		
	}
	

}
