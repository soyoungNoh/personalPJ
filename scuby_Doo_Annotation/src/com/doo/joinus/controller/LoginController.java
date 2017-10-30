package com.doo.joinus.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.doo.util.CookieManager;


//클라이언트의 요청을 받기 위해서는 컨트롤러는 서블릿이어야 함 (서블릿 상속)
//web.xml에 서블릿 매핑을 해줘야 함
public class LoginController implements Controller{


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Cookie[] coos = request.getCookies();

		String cookieMid = CookieManager.getCookie(coos,"mid");
		String cookiePwd = CookieManager.getCookie(coos,"pwd");


		System.out.println("cookieMid : "+cookieMid);
		System.out.println("cookiePwd : "+cookiePwd);

		ModelAndView mv = new ModelAndView();

		if(cookieMid != null && cookieMid != "" && cookiePwd != null && cookiePwd != "")
		{
			mv.setViewName("redirect:loginProc.do?mid="+cookieMid+"&pwd="+cookiePwd);
			return mv;
		}else
		{
			if(cookieMid != null && cookieMid != ""){
				mv.addObject("cookieMid", cookieMid);
			}	
			if(cookiePwd != null && cookiePwd != ""){
				mv.addObject("cookiePwd", cookiePwd);
			}
			mv.setViewName("login.jsp");
			return mv;
		}

	}

}