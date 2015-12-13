package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Provider;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProviderDAOImpl implements ProviderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProvider(Provider provider) {
		sessionFactory.getCurrentSession().save(provider);
	}

	@SuppressWarnings("unchecked")
	public List<Provider> listProvider() {

		return sessionFactory.getCurrentSession().createQuery("from Provider").list();
	}

	public void removeProvider(Integer id) {
		Provider provider = (Provider) sessionFactory.getCurrentSession().load(
				Provider.class, id);
		if (null != provider) {
			sessionFactory.getCurrentSession().delete(provider);
		}

	}

}
