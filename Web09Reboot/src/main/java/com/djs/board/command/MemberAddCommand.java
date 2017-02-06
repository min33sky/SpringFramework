package com.djs.board.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;
import com.djs.board.vo.Member;

//@Service("memberAdd")
//public class MemberAddCommand implements Command{

//	@Autowired
//	MemberDao dao;
//	
//	@Override
//	public void execute(Model model) {
//		
//		Map<String, Object> map = model.asMap();
//		Member member = (Member) map.get("member");
//		System.out.println(member.getName());
//		System.out.println(member.getEmail());
//		System.out.println(member.getPassword());
//		dao.add(member);
		
//	}

//}
