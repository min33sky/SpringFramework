package com.djs.board;

import java.util.Locale;
import java.util.Map;

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
	 * 로그인 폼
	 */
	@RequestMapping("/auth/loginForm")
	public String loginForm(Model model){
		logger.info("Login Form");
		return "auth/loginForm";
	}
	
	/*
	 * 로그인
	 */
	@RequestMapping(value = "/auth/login", method=RequestMethod.POST)
	public String login(Model model, Member member, HttpServletRequest request) throws Exception{
		logger.info("Login");
		Map<String, Object> map = model.asMap();
		model.addAttribute("request", request);
		model.addAttribute("member", member);
		command = (Command) ctx.getBean("login");
		command.execute(model);
		
		// 로그인 결과를 가져온다.
		String result = (String) map.get("loginResult");
		System.out.println(result);
		
		// 회원이 없을 시
		if(result.equals("fail")){
			return "/auth/loginForm";
		}
		return "redirect:/member/list";
	}
	
	/*
	 * 로그아웃
	 */
	@RequestMapping("/auth/logout")
	public String logout(Model model, HttpServletRequest request) throws Exception{
		logger.info("Logout");
		model.addAttribute("request", request);
		command = (Command) ctx.getBean("logout");
		command.execute(model);
		return "redirect:/member/list";
	}
	/*
	 * 회원 목록
	 */
	@RequestMapping("/member/list")
	public String memberList(Model model, HttpServletRequest request) throws Exception{
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
		logger.info("Member Register");
		return "memberForm";
	}
	
	/*
	 * 회원 등록
	 */
	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String memberAdd(Model model, Member member, HttpServletRequest request) {
		model.addAttribute("request", request);
		model.addAttribute("member", member);
		
		// 커맨드에 전달
		command = (Command) ctx.getBean("memberAdd");
		try {
			command.execute(model);
		} catch (Exception e) {
			System.err.println("************* 중복키 에러 *************");
			model.addAttribute("error", "duplicateKey");
			return "memberForm";
		}
		return "redirect:/member/list";
	}
	
	/*
	 * 회원 삭제
	 */
	@RequestMapping("/member/delete")
	public String memberDelete(Model model, HttpServletRequest request) throws Exception{
		logger.info("Delete");
		model.addAttribute("request", request);
		
		command = (Command) ctx.getBean("memberDelete");
		command.execute(model);
		
		return "redirect:/member/list";
	}
	
	
	/*
	 * 프로젝트 리스트
	 */
	@RequestMapping(value = "/project/list")
	public String projectList(Model model) throws Exception{
		logger.info("Welcome! ProjectPage");
		command = (Command) ctx.getBean("projectList");
		command.execute(model);
		return "projectList";
	}
	
}
