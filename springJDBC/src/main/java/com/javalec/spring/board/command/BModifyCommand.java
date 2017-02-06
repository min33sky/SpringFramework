package com.javalec.spring.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;

/*
 * 글 수정 서비스 객체
 */
@Service("modify")
public class BModifyCommand implements BCommand{

	@Autowired
	BDao dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
//		BDao dao = new BDao();
		dao.modify(bId, bName, bTitle, bContent);
		
	}

}
