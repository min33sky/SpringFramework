package com.djs.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;
import com.djs.board.vo.Member;

@Service("login")
public class LoginCommand implements Command{

	@Autowired
	MemberDao dao;
	
	@Override
	public void execute(Model model) throws Exception {
		Map<String, Object> map = model.asMap();
		Member loginInfo = (Member) map.get("member");
		
		
		Member member = dao.exist(loginInfo);
		
		if(member == null){
			model.addAttribute("loginResult", "fail");
		}else{
			HttpSession session = (HttpSession) map.get("session");
			session.setAttribute("member", member);
			model.addAttribute("loginResult", "success");
		}
		
	}

}
