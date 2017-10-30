package com.doo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doo.util.CookieManager;

@Controller
public class JoinusController {
	
	@RequestMapping("/joinus/login.do")
	public String login(HttpServletRequest request, Model model){

		Cookie[] coos = request.getCookies();

		String cookieMid = CookieManager.getCookie(coos,"mid");
		String cookiePwd = CookieManager.getCookie(coos,"pwd");


		System.out.println("cookieMid : "+cookieMid);
		System.out.println("cookiePwd : "+cookiePwd);

		if(cookieMid != null && cookieMid != "" && cookiePwd != null && cookiePwd != "")
		{
			return "redirect:loginProc.do?mid="+cookieMid+"&pwd="+cookiePwd;
		}else
		{
			if(cookieMid != null && cookieMid != ""){
				model.addAttribute("cookieMid", cookieMid);
			}	
			if(cookiePwd != null && cookiePwd != ""){
				model.addAttribute("cookiePwd", cookiePwd);
			}
			return "login.jsp";
		}
		
	}

}
