package com.javalec.spring.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;
import com.javalec.spring.board.vo.BVo;

/*
 * 게시판의 내용을 보는 곳
 */
@Service("content")
public class BContentCommand implements BCommand {

	@Autowired
	BDao dao;
	
	@Override
	public void execute(Model model) {
		
		/*
		 * model을 map으로 변환 후 Controller에서 전달된 request객체를 꺼낸다.
		 */
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
//		BDao dao = new BDao();
		BVo vo = dao.contentView(bId);
		
		model.addAttribute("content_view", vo);
	}
	
}
