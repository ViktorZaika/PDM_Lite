package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Project_Files_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Project_Files_LinksDAOImpl implements Project_Files_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProject_Files_Links(Project_Files_Links project_Files_Links) {
		sessionFactory.getCurrentSession().save(project_Files_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Project_Files_Links> listProject_Files_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Project_Files_Links").list();
	}

	public void removeProject_Files_Links(Integer id) {
		Project_Files_Links project_Files_Links = (Project_Files_Links) sessionFactory.getCurrentSession().load(
				Project_Files_Links.class, id);
		if (null != project_Files_Links) {
			sessionFactory.getCurrentSession().delete(project_Files_Links);
		}

	}

}
