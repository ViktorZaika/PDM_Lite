package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Project_User_Links;

public interface Project_User_LinksDAO {

	public void addProject_User_Links(Project_User_Links project_User_Links);

	public List<Project_User_Links> listProject_User_Links();

	public void removeProject_User_Links(Integer id);

}
