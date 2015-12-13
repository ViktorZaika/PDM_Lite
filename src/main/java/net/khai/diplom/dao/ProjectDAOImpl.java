package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Project;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProject(Project project) {
		sessionFactory.getCurrentSession().save(project);
	}

	@SuppressWarnings("unchecked")
	public List<Project> listProject() {

		return sessionFactory.getCurrentSession().createQuery("from Project").list();
	}

	public void removeProject(Integer id) {
		Project project = (Project) sessionFactory.getCurrentSession().load(
				Project.class, id);
		if (null != project) {
			sessionFactory.getCurrentSession().delete(project);
		}

	}

}
