package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Project;

public interface ProjectDAO {

	public void addProject(Project project);

	public List<Project> listProject();

	public void removeProject(Integer id);

}
