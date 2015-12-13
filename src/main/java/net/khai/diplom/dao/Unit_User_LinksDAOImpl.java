package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Unit_User_Links;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Unit_User_LinksDAOImpl implements Unit_User_LinksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUnit_User_Links(Unit_User_Links unit_User_Links) {
		sessionFactory.getCurrentSession().save(unit_User_Links);
	}

	@SuppressWarnings("unchecked")
	public List<Unit_User_Links> listUnit_User_Links() {

		return sessionFactory.getCurrentSession().createQuery("from Unit_User_Links").list();
	}

	public void removeUnit_User_Links(Integer id) {
		Unit_User_Links unit_User_Links = (Unit_User_Links) sessionFactory.getCurrentSession().load(
				Unit_User_Links.class, id);
		if (null != unit_User_Links) {
			sessionFactory.getCurrentSession().delete(unit_User_Links);
		}

	}

}
