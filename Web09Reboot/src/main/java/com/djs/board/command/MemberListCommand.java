package com.djs.board.command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;
import com.djs.board.vo.Member;

@Service("memberList")
public class MemberListCommand implements Command{

	@Autowired
	MemberDao dao;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String orderCond = request.getParameter("orderCond");
		
		List<Member> list = dao.selectList(orderCond);
		model.addAttribute("list", list);			// Member Objects 
		model.addAttribute("orderCond", orderCond);	// Sort
	}

}
