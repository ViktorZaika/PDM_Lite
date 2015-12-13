package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Project;

public interface ProjectService {
	
	public void addProject(Project project);

	public List<Project> listProject();

	public void removeProject(Integer id);
}
