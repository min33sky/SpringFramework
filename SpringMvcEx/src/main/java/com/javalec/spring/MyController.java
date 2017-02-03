package com.javalec.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.student.StudentInformation;

@Controller
public class MyController {

	@RequestMapping("/index")
	public String goIndex(){
		return "index";
	}
	
	// Get으로 받기
	@RequestMapping(value="/student", method = RequestMethod.GET)
	public String goStudent(@RequestParam("id") String id, Model model){
		model.addAttribute("studentId", id);
		return "student/studentId";
	}
	// Post로 받기 (같은 메서드 이름을 사용하기 위해 오버라이딩 이용)
	@RequestMapping(value="/student", method = RequestMethod.POST)
	public ModelAndView goStudent(@RequestParam("id") String id){
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentId", id);
		mv.setViewName("student/studentId");
		return mv;
	}
	
	// @ModelAttribute를 사용하면 커맨드 객체의 이름을 마음대로 수정할 수 있다.
	@RequestMapping("/studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation){
		return "studentView";
	}
	
}
