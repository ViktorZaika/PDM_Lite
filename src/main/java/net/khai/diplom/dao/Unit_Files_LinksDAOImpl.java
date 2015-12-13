package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Unit_Files_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Unit_Files_LinksDAOImpl implements Unit_Files_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUnit_Files_Links(Unit_Files_Links unit_Files_Links) {
		sessionFactory.getCurrentSession().save(unit_Files_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Unit_Files_Links> listUnit_Files_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Unit_Files_Links").list();
	}

	public void removeUnit_Files_Links(Integer id) {
		Unit_Files_Links unit_Files_Links = (Unit_Files_Links) sessionFactory.getCurrentSession().load(
				Unit_Files_Links.class, id);
		if (null != unit_Files_Links) {
			sessionFactory.getCurrentSession().delete(unit_Files_Links);
		}

	}

}
