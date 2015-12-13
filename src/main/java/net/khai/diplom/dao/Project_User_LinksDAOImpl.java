package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Project_User_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Project_User_LinksDAOImpl implements Project_User_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProject_User_Links(Project_User_Links project_User_Links) {
		sessionFactory.getCurrentSession().save(project_User_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Project_User_Links> listProject_User_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Project_User_Links").list();
	}

	public void removeProject_User_Links(Integer id) {
		Project_User_Links project_User_Links = (Project_User_Links) sessionFactory.getCurrentSession().load(
				Project_User_Links.class, id);
		if (null != project_User_Links) {
			sessionFactory.getCurrentSession().delete(project_User_Links);
		}

	}

}
