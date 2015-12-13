package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.Unit_User_LinksDAO;
import net.khai.diplom.domain.Unit_User_Links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Unit_User_LinksServiceImpl implements Unit_User_LinksService{

	@Autowired
	private Unit_User_LinksDAO unit_User_LinksDAO;

	@Transactional
	public void addUnit_User_Links(Unit_User_Links unit_User_Links) {
		unit_User_LinksDAO.addUnit_User_Links(unit_User_Links);
	}

	@Transactional
	public List<Unit_User_Links> listUnit_User_Links() {

		return unit_User_LinksDAO.listUnit_User_Links();
	}

	@Transactional
	public void removeUnit_User_Links(Integer id) {
		unit_User_LinksDAO.removeUnit_User_Links(id);
	}
}
