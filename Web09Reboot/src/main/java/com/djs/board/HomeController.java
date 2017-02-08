package com.djs.board;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String memberList(Model model, HttpServletRequest request) throws Exception{
		String path = request.getRequestURI();
		String cp = request.getContextPath();
		String sId = request.getRequestedSessionId();
		logger.info("Welcome! homepage " + path);
		logger.info("Welcome! homepage " + cp);
		logger.info("Welcome! homepage " + sId);
		
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
	public String memberAdd(Model model, Member member) {
		logger.info("회원 등록 : " + member.getEmail());
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
	 * 회원 수정 폼
	 */
	@RequestMapping(value = "/member/update", method=RequestMethod.GET)
	public String memberUpdateForm(Model model, @RequestParam String no) throws Exception{
		logger.info("Member Update Form");
		System.out.println("어떤 것을 수정 :" + no);
		model.addAttribute("no", no);
		command = (Command) ctx.getBean("memberUpdate");
		command.execute(model);
		return "memberUpdateForm";
	}
	
	/*
	 * 회원 수정
	 */
	@RequestMapping(value = "/member/update", method=RequestMethod.POST)
	public String memberUpdate(Model model, Member member) throws Exception{
		logger.info("Member Update");
		model.addAttribute("member", member);
		command = (Command) ctx.getBean("memberUpdate");
		try{
			command.execute(model);
		} catch (Exception e){
			System.err.println("************* 중복키 에러 *************");
			model.addAttribute("error", "duplicateKey");
			return "memberUpdateForm";
		}
		return "redirect:list";
	}
	
	/*
	 * 회원 삭제
	 */
	@RequestMapping("/member/delete")
	public String memberDelete(Model model, @RequestParam String no) throws Exception{
		logger.info("Delete : " + no + "번 게시글");
		model.addAttribute("no", no);
		command = (Command) ctx.getBean("memberDelete");
		command.execute(model);
		
		return "redirect:/member/list";
	}
	
}
