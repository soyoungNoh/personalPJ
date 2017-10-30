package com.doo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class downloadContraller implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getParameter("p");
		String fname = request.getParameter("fname");
		//String urlFname=URLEncoder.encode(fname, "UTF-8");
		
	
		String urlPath = path+"/"+fname;
		String realPath = request.getServletContext().getRealPath(urlPath);
		System.out.println("urlPath : " + urlPath);
		System.out.println("realPath : " + realPath);
		
		String newfname = new String(fname.getBytes(),"ISO-8859-1");
		
		//다운로드 실행
		response.setHeader("Content-Disposition", "attachment;filename="+newfname);
		
		//스트림을 열어줌
		FileInputStream fis = new FileInputStream(realPath);
		ServletOutputStream sout = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		int fileSize = 0;
		while((fileSize=fis.read(buf))!=-1){
			sout.write(buf);
		}
		fis.close();
		sout.close();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("void:");
		return mv;
	}

}
