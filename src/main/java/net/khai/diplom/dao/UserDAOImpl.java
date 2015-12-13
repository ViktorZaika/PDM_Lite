package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	 @Override
	 public User getUserByUsername(String username) {
	 Session session = sessionFactory.getCurrentSession();
	 session.beginTransaction();
	 List<User> users = session.createQuery("from User").list();
	 User result = null;
	 for(User user: users) {
	 if(user.getLogin().equals(username))
	 result = user;
	 }
	 session.getTransaction().commit();
	 return result;
	 }
	 
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {

		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}

}
