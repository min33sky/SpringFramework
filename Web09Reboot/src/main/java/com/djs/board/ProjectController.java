package com.djs.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djs.board.command.Command;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {
	// Log
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	// ApplicationContext
	@Autowired
	ApplicationContext ctx;
	Command command;
	
	
	/*
	 * 프로젝트 리스트
	 */
	@RequestMapping(value = "/project/list")
	public String projectList(Model model) {
		logger.info("Welcome! ProjectPage");
		command = (Command) ctx.getBean("projectList");
		command.execute(model);
		return "projectList";
	}
	
}
