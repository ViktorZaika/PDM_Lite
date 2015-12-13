
package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Projects_Links;


public interface Project_LinksDAO {

	public void addProjects_Links(Projects_Links Project_Links);

	public List<Projects_Links> listProjects_Links();

	public void removeProjects_Links(Integer id);
}
