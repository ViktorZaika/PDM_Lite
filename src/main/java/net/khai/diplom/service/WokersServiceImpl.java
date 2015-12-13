package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.WokersDAO;
import net.khai.diplom.domain.Wokers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WokersServiceImpl implements WokersService{

	@Autowired
	private WokersDAO wokersDAO;

	@Transactional
	public void addWokers(Wokers wokers) {
		wokersDAO.addWokers(wokers);
	}

	@Transactional
	public List<Wokers> listWokers() {

		return wokersDAO.listWokers();
	}

	@Transactional
	public void removeWokers(Integer id) {
		wokersDAO.removeWokers(id);
	}
}
