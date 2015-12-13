package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Project_Files_Links;

public interface Project_Files_LinksDAO {

	public void addProject_Files_Links(Project_Files_Links project_Files_Links);

	public List<Project_Files_Links> listProject_Files_Links();

	public void removeProject_Files_Links(Integer id);

}
