package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.ProjectDAO;
import net.khai.diplom.domain.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDAO projectDAO;

	@Transactional
	public void addProject(Project project) {
		projectDAO.addProject(project);
	}

	@Transactional
	public List<Project> listProject() {

		return projectDAO.listProject();
	}

	@Transactional
	public void removeProject(Integer id) {
		projectDAO.removeProject(id);
	}
}
