package com.djs.board.command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("logout")
public class LogoutCommand implements Command{

	@Override
	public void execute(Model model) throws DataIntegrityViolationException{
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession) map.get("session");
		session.invalidate();
	}

}
