package com.javalec.spring.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;
import com.javalec.spring.board.vo.BVo;

public class BReplyViewCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BVo vo = dao.replyView(bId);
		model.addAttribute("reply_view", vo);
	}

}
