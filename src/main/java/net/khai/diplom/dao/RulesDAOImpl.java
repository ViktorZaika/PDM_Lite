package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Rules;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RulesDAOImpl implements RulesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addRules(Rules rules) {
		sessionFactory.getCurrentSession().save(rules);
	}

	@SuppressWarnings("unchecked")
	public List<Rules> listRules() {

		return sessionFactory.getCurrentSession().createQuery("from Rules").list();
	}

	public void removeRules(Integer id) {
		Rules rules = (Rules) sessionFactory.getCurrentSession().load(
				Rules.class, id);
		if (null != rules) {
			sessionFactory.getCurrentSession().delete(rules);
		}

	}

}
