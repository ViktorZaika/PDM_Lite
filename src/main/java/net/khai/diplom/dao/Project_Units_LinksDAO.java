package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Project_Units_Links;

public interface Project_Units_LinksDAO {

	public void addProject_Units_Links(Project_Units_Links project_Units_Links);

	public List<Project_Units_Links> listProject_Units_Links();

	public void removeProject_Units_Links(Integer id);

}
