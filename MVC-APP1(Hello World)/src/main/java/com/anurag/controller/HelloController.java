package com.anurag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.anurag.service.HelloService;

public class HelloController implements Controller{
	
	private HelloService helloService;
	private String message;
	private String targetView="WEB-INF/pages/showMessage.jsp";

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name= request.getParameter("name");
		if (name!=null && name.trim().length()>0) {
			message=helloService.sayHello(name);
		}else {
			message=helloService.sayHello("Guest");
		}
		ModelAndView modelAndView=new ModelAndView(targetView, "message", message);
		return modelAndView;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
}
