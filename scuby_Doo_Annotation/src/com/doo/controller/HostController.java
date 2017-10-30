package com.doo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class HostController {

	private MemberDAO mdao;
	private BusinessDAO bdao;
	
	@Autowired
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}
	
	@Autowired
	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}
	
	@RequestMapping("/host/bManage.do")
	public String bManage(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		session.setAttribute("mid", mid);
		
		Member m = mdao.getMember(mid);
		
		Business b = bdao.getBusiness(mid);

		model.addAttribute("m", m);
		model.addAttribute("b", b);
		
		return "bManage.jsp";
	}
	
	@RequestMapping("/host/businessAdd.do")
	public String businessAdd(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		session.setAttribute("mid", mid);
		
		Member m = mdao.getMember(mid);
		
		
		model.addAttribute("m", m);
		
		return "businessAdd.jsp";	
	}
	
	@RequestMapping("/host/businessAddProc.do")
	public String businessAddProc(HttpServletRequest request) throws IOException	{
		
		HttpSession session = request.getSession();
		
		
		String path="/host/upload";
		String realPath = request.getServletContext().getRealPath(path); 
		System.out.println("realPath : "+realPath);
		
		MultipartRequest mulReq = new MultipartRequest(request, realPath, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String fileSrc = mulReq.getFilesystemName("file");
		String orifileSrc = mulReq.getOriginalFileName("file");
		System.out.println("fileSrc : "+fileSrc);
		System.out.println("orifileSrc : "+orifileSrc);
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dept = mulReq.getParameter("dept");
		String bName = mulReq.getParameter("bName");
		String location = mulReq.getParameter("location");
		String address = mulReq.getParameter("address");
		String intro = mulReq.getParameter("intro");
		String price = mulReq.getParameter("price");
		int iprice = Integer.parseInt(price);
		String fullAddress = location+" "+address;
		
		String mid = (String)session.getAttribute("mid");
		
		System.out.println("bName : "+bName);
		System.out.println("address : "+address);
		
		Business b = new Business();
		
		b.setDept(dept);
		b.setName(bName);
		b.setAddress(fullAddress);
		b.setIntro(intro);
		b.setMid(mid);
		b.setFileSrc(fileSrc);
		b.setPrice(iprice);
		
		int af = bdao.addBusiness(b);
		
		if(af==1)
		{
			System.out.println("새 업체 저장 성공");
			
			return "redirect:../myPage/myPage.do";
		}else
		{
			System.out.println("새 업체 저장 실패");
			return null;
		}
	}
	@RequestMapping("/host/businessEdit.do")
	public String businessEdit(HttpServletRequest request,Model model){
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		session.setAttribute("mid", mid);	

		Business b = bdao.getBusiness(mid);
		
		Member m = mdao.getMember(mid);
		
		
		model.addAttribute("m",m);
		model.addAttribute("b",b);
		
		return "businessEdit.jsp";
	}
	
	@RequestMapping("/host/businessEditProc.do")
	public String businessEditProc(HttpServletRequest request) throws IOException{
		String path="/host/upload";
		String realPath = request.getServletContext().getRealPath(path); 
		System.out.println("realPath : "+realPath);
		
		MultipartRequest mulReq = new MultipartRequest(request, realPath, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String fileSrc = mulReq.getFilesystemName("file");
		String orifileSrc = mulReq.getOriginalFileName("file");
		System.out.println("fileSrc : "+fileSrc);
		System.out.println("orifileSrc : "+orifileSrc);
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dept = mulReq.getParameter("dept");
		String name = mulReq.getParameter("bName");
		String location = mulReq.getParameter("location");
		String address = mulReq.getParameter("address");
		String file = mulReq.getParameter("file");
		String intro = mulReq.getParameter("intro");
		String price = mulReq.getParameter("price");
		int iprice = Integer.parseInt(price);

		String fullAddress = location+" "+address;
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		System.out.println("name : "+name);
		System.out.println("fullAddress : "+fullAddress);
		
		Business b = new Business();
		
		b=bdao.getBusiness(mid);
		
		b.setDept(dept);
		b.setName(name);
		b.setAddress(fullAddress);
		b.setFileSrc(fileSrc);
		b.setIntro(intro);
		b.setPrice(iprice);
		
		int af = bdao.updateB(b);
		
		
		if (af == 1) {
			System.out.println("회원수정 성공");
			return "redirect:bManage.do";
		} else {
			System.out.println("회원수정 실패");
			return null;
		}
		
	}
	
	@RequestMapping("/host/businessDelProc.do")
	public String businessDelProc(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		

		int af = bdao.delBusiness(mid);
		
		ModelAndView mv = new ModelAndView();

		
		if(af>=1){
			System.out.println("업체 삭제에 성공하였습니다.");
			return "redirect:../myPage/myPage.do";

		}else{
			System.out.println("업체 삭제에 실패하였습니다.");
			return "redirect:../myPage/myPage.do";
		}
	}
	
	@RequestMapping("/host/businessDetail.do")
	public String businessDetail(String mid, String hitOn, Model model){
		
		int af=0;
		
		Business b = new Business();
		
		b = bdao.getBusiness(mid);
		
		if(hitOn !=null && !hitOn.equals("")){
			af = bdao.hitUp(mid);
			if(af>0){
				System.out.println("조회수 변경 완료");
			}else{
				System.out.println("조회수 변경 실패");		
			}
		}			
		
		model.addAttribute("b", b);
		return "businessDetail.jsp";

		
	}
}
