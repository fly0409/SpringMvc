package com.tl.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginDemoInterceptor implements HandlerInterceptor {
	  @Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {
		  HttpSession session = request.getSession();
		  Object user = session.getAttribute("loginUser");
		  if (user==null) {
			  System.out.println("no session,back to Login");
			  response.sendRedirect("/SpringMvcPractice/login.MainPage");
			   return false;
		  }
	        System.out.println("Inside pre handle");
	        return true;
	    }
	 
	    @Override
	    public void postHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	    	
	        System.out.println("Inside post handle");
	    }
	 
	    @Override
	    public void afterCompletion(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception exception)
	            throws Exception {
	 
	        System.out.println("Inside after completion");
	    }
	}
