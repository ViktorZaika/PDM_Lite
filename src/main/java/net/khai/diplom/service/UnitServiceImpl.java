package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.UnitDAO;
import net.khai.diplom.domain.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnitServiceImpl implements UnitService{

	@Autowired
	private UnitDAO unitDAO;

	@Transactional
	public void addUnit(Unit unit) {
		unitDAO.addUnit(unit);
	}

	@Transactional
	public List<Unit> listUnit() {

		return unitDAO.listUnit();
	}

	@Transactional
	public void removeUnit(Integer id) {
		unitDAO.removeUnit(id);
	}
}
