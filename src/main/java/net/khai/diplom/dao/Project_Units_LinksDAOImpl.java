package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Project_Units_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Project_Units_LinksDAOImpl implements Project_Units_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProject_Units_Links(Project_Units_Links project_Units_Links) {
		sessionFactory.getCurrentSession().save(project_Units_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Project_Units_Links> listProject_Units_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Project_Units_Links").list();
	}

	public void removeProject_Units_Links(Integer id) {
		Project_Units_Links project_Units_Links = (Project_Units_Links) sessionFactory.getCurrentSession().load(
				Project_Units_Links.class, id);
		if (null != project_Units_Links) {
			sessionFactory.getCurrentSession().delete(project_Units_Links);
		}

	}

}
