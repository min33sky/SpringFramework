package com.javalec.spring.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring.board.command.BCommand;
import com.javalec.spring.board.command.BContentCommand;
import com.javalec.spring.board.command.BDeleteCommand;
import com.javalec.spring.board.command.BListCommand;
import com.javalec.spring.board.command.BModifyCommand;
import com.javalec.spring.board.command.BReplyCommand;
import com.javalec.spring.board.command.BReplyViewCommand;
import com.javalec.spring.board.command.BWriteCommand;
import com.javalec.spring.board.util.Constant;


@Controller
public class BController {
	
	private static final Logger logger = LoggerFactory.getLogger(BController.class);
	
	BCommand command;	// 서비스 객체 (인터페이스 타입)
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;	// 다른 클래스에서 template 사용 허용
	}

	/*
	 * 게시물 리스트 출력
	 */
	@RequestMapping(value={"/", "/list"})
	public String list(Model model){
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	/*
	 * 게시물 작성 폼으로 이동
	 */
	@RequestMapping("/write_view")
	public String writeView(Model model){
		System.out.println("writeView()");
		return "write_view";
	}
	
	/*
	 * 게시물 작성
	 */
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write()");
		/*
		 * 입력 받은 값들을 담은 request 객체를 Model에 넣는다.
		 * 그리고 서비스 객체에 그 Model을 매개변수로 넘겨준다.
		 */
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	// 게시물 보기
	@RequestMapping("/content_view")
	public String contentView(HttpServletRequest request, Model model){
		System.out.println("contentView()");
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	// 게시물 답변 폼 
	@RequestMapping("/reply_view")
	public String replyView(HttpServletRequest request, Model model){
		System.out.println("replyView()");
		
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		return "reply_view";
	}
	
	// 게시물 답글 작성
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(model);
		return "redirect:list";
	}

	// 게시물 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}
}
