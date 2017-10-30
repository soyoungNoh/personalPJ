package com.doo.host.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.dao.BusinessDAO;
import com.doo.vo.Business;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BusinessEditProcController implements Controller{

	private BusinessDAO bdao;
	
	public void setBdao(BusinessDAO bdao) {
		this.bdao = bdao;
	}
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		ModelAndView mv = new ModelAndView();
		
		if (af == 1) {
			System.out.println("회원수정 성공");
			mv.setViewName("redirect:bManage.do");
			return mv;
		} else {
			System.out.println("회원수정 실패");
			return null;
		}
	}

}
