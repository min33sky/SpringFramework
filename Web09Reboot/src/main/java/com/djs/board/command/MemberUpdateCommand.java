package com.djs.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;
import com.djs.board.vo.Member;

@Service("memberUpdate")
public class MemberUpdateCommand implements Command{

	@Autowired
	MemberDao dao;

	@Override
	public void execute(Model model) throws Exception {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		if(request != null){
			String no = request.getParameter("no");
			Member member = dao.selectOne(Integer.parseInt(no));
			model.addAttribute("member", member);
			
		}else{
			System.out.println("수정입니다.");
			Member member = (Member) map.get("member");
			String name = member.getName();
			String email = member.getEmail();
			System.out.println(name+", "+email);
			dao.update(member);
		}		
	}
	
	
}
