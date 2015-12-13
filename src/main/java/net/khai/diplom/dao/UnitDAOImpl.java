package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Unit;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UnitDAOImpl implements UnitDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUnit(Unit unit) {
		sessionFactory.getCurrentSession().save(unit);
	}

	@SuppressWarnings("unchecked")
	public List<Unit> listUnit() {

		return sessionFactory.getCurrentSession().createQuery("from Unit").list();
	}

	public void removeUnit(Integer id) {
		Unit unit = (Unit) sessionFactory.getCurrentSession().load(
				Unit.class, id);
		if (null != unit) {
			sessionFactory.getCurrentSession().delete(unit);
		}

	}

}
