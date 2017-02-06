package com.javalec.spring.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.javalec.spring.board.dao.BDao;

@Service("write")
public class BWriteCommand implements BCommand{
	
	@Autowired
	BDao dao;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // Model을 Map형태로 바꾼다.
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
//		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
