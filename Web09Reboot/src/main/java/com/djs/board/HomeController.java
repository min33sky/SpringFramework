package com.djs.board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.djs.board.command.Command;
import com.djs.board.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// Log
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// ApplicationContext
	@Autowired
	ApplicationContext ctx;
	Command command;
	
	@RequestMapping(value = {"/"})
	public String home(Locale locale, Model model) {
		
		return "redirect:member/list";
	}
	
	/*
	 * 회원 목록
	 */
	@RequestMapping("/member/list")
	public String memberList(Model model, HttpServletRequest request){
		logger.info("Welcome! homepage");
		
		model.addAttribute("request", request);
		command = (Command) ctx.getBean("memberList");
		// 리스트 가져오기
		command.execute(model);
		
		return "memberList";
	}
	
	/*
	 * 회원 등록 폼
	 */
	@RequestMapping("/member/addForm")
	public String memberAddForm(Model model){
		return "memberForm";
	}
	
	/*
	 * 회원 등록
	 */
//	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
//	public String memberAdd(Model model, Member member, HttpServletRequest request){
//		model.addAttribute("request", request);
//		model.addAttribute("member", member);
//		
//		// 커맨드에 전달
//		command = (Command) ctx.getBean("memberAdd");
//		command.execute(model);
//		
//		return "redirect:/member/list";
//	}
//	
	
	@RequestMapping(value = "/project/list")
	public String projectList(Model model){
		logger.info("Welcome! ProjectPage");
		command = (Command) ctx.getBean("projectList");
		command.execute(model);
		return "projectList";
	}
	
}
