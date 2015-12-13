package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.Project_User_LinksDAO;
import net.khai.diplom.domain.Project_User_Links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Project_User_LinksServiceImpl implements Project_User_LinksService{

	@Autowired
	private Project_User_LinksDAO project_User_LinksDAO;

	@Transactional
	public void addProject_User_Links(Project_User_Links project_User_Links) {
		project_User_LinksDAO.addProject_User_Links(project_User_Links);
	}

	@Transactional
	public List<Project_User_Links> listProject_User_Links() {

		return project_User_LinksDAO.listProject_User_Links();
	}

	@Transactional
	public void removeProject_User_Links(Integer id) {
		project_User_LinksDAO.removeProject_User_Links(id);
	}
}
