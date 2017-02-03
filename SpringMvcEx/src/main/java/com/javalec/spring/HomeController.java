package com.javalec.spring;	// 패키지 3번째가 컨텍스트 이름 (ex. spring)

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.member.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	// 요청 경로(path) + http method
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";	// 뷰 이름 리턴
	}

	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest req, Model model){
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}

	// HttpServletRequest 대신 @RequestParam으로 처리 가능
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model){
		model.addAttribute("identity", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}
	
	@RequestMapping("/join/joinMember")
	public String joinMember(){
		return "join/joinForm";
	}
	
	// parameter로 데이터(커맨드) 객체를 받아서 많은 입력값을 쉽게 처리 가능 
	@RequestMapping(value="/join/form", method=RequestMethod.POST)
	public String join(Member member){
		return "join/formOk";
	}
	
	// @PathVariable : path에 변수를 넣어 메소드에서 파라미터로 이용 가능
	@RequestMapping("/student/{studentId}")
	public String getStudent(@PathVariable String studentId, Model model){
		model.addAttribute("studentId", studentId);
		return "studentView";
	}
	
	
	@RequestMapping(value="/board/view")
	public String view(){
		return "board/view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model){
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply(){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		mv.setViewName("board/reply");
		
		return mv;
	}
	
}
