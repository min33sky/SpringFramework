package com.djs.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;

@Service("memberDelete")
public class MemberDeleteCommand implements Command{

	@Autowired
	MemberDao dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String no = request.getParameter("no");
		
		dao.delete(Integer.parseInt(no));
		
	}

}
