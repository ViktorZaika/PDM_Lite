package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.Project_Units_LinksDAO;
import net.khai.diplom.domain.Project_Units_Links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Project_Units_LinksServiceImpl implements Project_Units_LinksService{

	@Autowired
	private Project_Units_LinksDAO project_Units_LinksDAO;

	@Transactional
	public void addProject_Units_Links(Project_Units_Links project_Units_Links) {
		project_Units_LinksDAO.addProject_Units_Links(project_Units_Links);
	}

	@Transactional
	public List<Project_Units_Links> listProject_Units_Links() {

		return project_Units_LinksDAO.listProject_Units_Links();
	}

	@Transactional
	public void removeProject_Units_Links(Integer id) {
		project_Units_LinksDAO.removeProject_Units_Links(id);
	}
}
