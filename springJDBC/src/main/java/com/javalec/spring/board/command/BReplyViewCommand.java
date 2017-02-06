package com.javalec.spring.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;
import com.javalec.spring.board.vo.BVo;

@Service("replyView")
public class BReplyViewCommand implements BCommand{

	@Autowired
	BDao dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
//		BDao dao = new BDao();
		BVo vo = dao.replyView(bId);
		model.addAttribute("reply_view", vo);
	}

}
