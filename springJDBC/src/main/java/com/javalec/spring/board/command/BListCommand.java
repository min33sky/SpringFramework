package com.javalec.spring.board.command;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;
import com.javalec.spring.board.vo.BVo;

/*
 * 게시물 리스트
 */
@Service("list")
public class BListCommand implements BCommand{

	@Autowired
	BDao dao;
	
	@Override
	public void execute(Model model) {
//		BDao dao = new BDao();
		ArrayList<BVo> vos = dao.list();
		model.addAttribute("list", vos);
	}

}
