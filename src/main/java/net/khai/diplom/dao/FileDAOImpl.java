package net.khai.diplom.dao;

import java.util.List;

import net.khai.diplom.domain.Files;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAOImpl implements FileDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addFile(Files file) {
		sessionFactory.getCurrentSession().save(file);
	}

	@SuppressWarnings("unchecked")
	public List<Files> listFile() {

		return sessionFactory.getCurrentSession().createQuery("from Files").list();
	}

	public void removeFile(Integer id) {
		Files file = (Files) sessionFactory.getCurrentSession().load(
				Files.class, id);
		if (null != file) {
			sessionFactory.getCurrentSession().delete(file);
		}

	}

}
