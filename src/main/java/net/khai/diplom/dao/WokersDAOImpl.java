package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Wokers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WokersDAOImpl implements WokersDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addWokers(Wokers wokers) {
		sessionFactory.getCurrentSession().save(wokers);
	}

	@SuppressWarnings("unchecked")
	public List<Wokers> listWokers() {

		return sessionFactory.getCurrentSession().createQuery("from Wokers").list();
	}

	public void removeWokers(Integer id) {
		Wokers wokers = (Wokers) sessionFactory.getCurrentSession().load(
				Wokers.class, id);
		if (null != wokers) {
			sessionFactory.getCurrentSession().delete(wokers);
		}

	}

}
