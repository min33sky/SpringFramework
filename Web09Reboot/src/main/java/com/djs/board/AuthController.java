package com.djs.board;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
 * 회원 관련 컨트롤러
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	// Log
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	// ApplicationContext
	@Autowired
	ApplicationContext ctx;
	Command command;
	
	/*
	 * 로그인 폼
	 */
	@RequestMapping("loginForm")
	public String loginForm(Model model){
		logger.info("Login Form");
		return "auth/loginForm";
	}
	
	/*
	 * 로그인
	 */
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(Model model, Member member, HttpSession session) {
		logger.info("Login");
		Map<String, Object> map = model.asMap();
		model.addAttribute("session", session);
		model.addAttribute("member", member);
		command = (Command) ctx.getBean("login");
		command.execute(model);
		
		// Get Login Result
		String loginResult = (String) map.get("loginResult");
		
		// Login Fail
		if(loginResult.equals("fail")){
			return "/auth/loginForm";
		}
		// Login Success
		return "redirect:/member/list";
	}

	/*
	 * 로그아웃
	 */
	@RequestMapping("logout")
	public String logout(Model model, HttpSession session) {
		logger.info("Logout");
		model.addAttribute("session", session);
		command = (Command) ctx.getBean("logout");
		command.execute(model);
		return "redirect:/member/list";
	}
	
	
	
}
