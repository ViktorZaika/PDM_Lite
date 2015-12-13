package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.Project_Files_LinksDAO;
import net.khai.diplom.domain.Project_Files_Links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Project_File_LinksServiceImpl implements Project_File_LinksService{

	@Autowired
	private Project_Files_LinksDAO project_File_Links_File_LinksDAO;

	@Transactional
	public void addProject_File_Links(Project_Files_Links project_File_Links) {
		project_File_Links_File_LinksDAO.addProject_Files_Links(project_File_Links);
	}

	@Transactional
	public List<Project_Files_Links> listProject_File_Links() {

		return project_File_Links_File_LinksDAO.listProject_Files_Links();
	}

	@Transactional
	public void removeProject_File_Links(Integer id) {
		project_File_Links_File_LinksDAO.removeProject_Files_Links(id);
	}
}
