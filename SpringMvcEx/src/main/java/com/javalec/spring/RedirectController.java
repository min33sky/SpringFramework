package com.javalec.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(@RequestParam("id") String id, Model model){
		if(id.equals("abc")){
			return "redirect:studentOk";
		}
		
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model){
		return "student/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(Model model){
		return "student/studentNg";
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model){
		return "redirect:http://localhost:8181/spring/studentURL1.jsp";
	}
	
	@RequestMapping("/studentURL2")
	public String studentURL2(Model model){
		return "redirect:student/studentURL2";
	}
	
	@RequestMapping("/student/studentURL2")
	public String studentURL22(Model model){
		return "redirect:http://localhost:8181/spring/studentURL2.jsp";
	}
	
}
