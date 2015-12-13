package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Project_Files_Links;

public interface Project_File_LinksService {
	
	public void addProject_File_Links(Project_Files_Links project_File_Links);

	public List<Project_Files_Links> listProject_File_Links();

	public void removeProject_File_Links(Integer id);
}
