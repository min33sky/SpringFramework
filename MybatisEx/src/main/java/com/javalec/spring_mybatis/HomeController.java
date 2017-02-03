package com.javalec.spring_mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_mybatis.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private SqlSession sqlSession;	// myBatis
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
//		IDao dao = sqlSession.getMapper(IDao.class);
//		model.addAttribute("list", dao.listDao());

		List<ContentDto> list = sqlSession.selectList("com.javalec.spring_mybatis.list");
		model.addAttribute("list", list);
		return "/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		String param1 = request.getParameter("mWriter");
		String param2 = request.getParameter("mContent");
		Map<String, String> map = new HashMap<String, String>();
		map.put("writer", param1);
		map.put("content", param2);
		sqlSession.insert("com.javalec.spring_mybatis.write", map);
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view() {
		return "/view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.deleteDao(request.getParameter("mId"));
		
		String id = request.getParameter("mId");
		sqlSession.delete("com.javalec.spring_mybatis.delete", id);
		return "redirect:list";
	}
	
}
