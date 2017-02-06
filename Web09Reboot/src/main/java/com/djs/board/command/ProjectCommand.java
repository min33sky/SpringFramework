package com.djs.board.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.djs.board.dao.ProjectDao;
import com.djs.board.vo.Project;

@Service("projectList")
public class ProjectCommand implements Command{

	@Autowired
	ProjectDao dao;
	
	@Override
	public void execute(Model model) {
		
		List<Project> list = dao.list();
		model.addAttribute("list", list);
	}

}
