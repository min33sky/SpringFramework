package com.javalec.spring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring.validate.StudentValidator;
import com.javalec.student.Student;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm(){
		return "createPage";
	}
	
	/*
	 * @Valid와 @InitBinder 사용으로 validator를 스프링이 자동으로 호출해준다.
	 */
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") @Valid Student student, BindingResult result){	
		
		String page = "createDonePage";
//		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		if(result.hasErrors()){
			page = "createPage";
		}
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new StudentValidator());
	}
	
	
}
