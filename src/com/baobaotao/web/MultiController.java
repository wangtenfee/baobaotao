package com.baobaotao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
@Controller 
@RequestMapping(value="/multi") 
public class MultiController{
	
	@RequestMapping(value="/delete", method=RequestMethod.GET) 
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("update"); 
		return new ModelAndView("/multi","message","update");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView xxxxx(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("add"); 
		return new ModelAndView("/multi","message","add");
	}
	

}
