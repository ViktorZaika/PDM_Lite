package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Projects_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Projects_LinksDAOImpl implements Project_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProjects_Links(Projects_Links Projects_Links) {
		sessionFactory.getCurrentSession().save(Projects_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Projects_Links> listProjects_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Projects_Links").list();
	}

	public void removeProjects_Links(Integer id) {
		Projects_Links Projects_Links = (Projects_Links) sessionFactory.getCurrentSession().load(
				Projects_Links.class, id);
		if (null != Projects_Links) {
			sessionFactory.getCurrentSession().delete(Projects_Links);
		}

	}

}
