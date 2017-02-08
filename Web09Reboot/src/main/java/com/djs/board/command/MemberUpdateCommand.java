package com.djs.board.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.MemberDao;
import com.djs.board.vo.Member;

@Service("memberUpdate")
public class MemberUpdateCommand implements Command{

	@Autowired
	MemberDao dao;

	@Override
	public void execute(Model model) throws DataIntegrityViolationException {
		Map<String, Object> map = model.asMap();
		String numberInfo = (String) map.get("no");
		System.out.println("numberInfo : " + numberInfo);
		
		if(numberInfo != null){
			// Get Method
			Member member = dao.selectOne(Integer.parseInt(numberInfo));
			model.addAttribute("member", member);
			
		}else{
			// Post Method
			Member member = (Member) map.get("member");
			dao.update(member);
		}		
	}
}
