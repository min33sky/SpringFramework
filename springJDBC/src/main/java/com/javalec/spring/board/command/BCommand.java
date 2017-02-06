package com.javalec.spring.board.command;

import org.springframework.ui.Model;

/*
 * 서비스 객체
 */
//@Component
public interface BCommand {
	void execute(Model model);
}
