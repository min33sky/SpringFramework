package com.djs.board.command;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;

public interface Command {
	void execute(Model model) throws DataIntegrityViolationException;
}
