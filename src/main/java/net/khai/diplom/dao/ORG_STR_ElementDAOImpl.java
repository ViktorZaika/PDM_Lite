package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.ORG_STR_Element;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ORG_STR_ElementDAOImpl implements ORG_STR_ElementDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addORG_STR_Element(ORG_STR_Element oRG_STR_Element) {
		sessionFactory.getCurrentSession().save(oRG_STR_Element);
	}

	@SuppressWarnings("unchecked")
	public List<ORG_STR_Element> listORG_STR_Element() {

		return sessionFactory.getCurrentSession().createQuery("from ORG_STR_Element").list();
	}

	public void removeORG_STR_Element(Integer id) {
		ORG_STR_Element oRG_STR_Element = (ORG_STR_Element) sessionFactory.getCurrentSession().load(
				ORG_STR_Element.class, id);
		if (null != oRG_STR_Element) {
			sessionFactory.getCurrentSession().delete(oRG_STR_Element);
		}

	}

}
