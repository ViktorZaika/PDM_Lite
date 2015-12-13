package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.Unit_Files_LinksDAO;
import net.khai.diplom.domain.Unit_Files_Links;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Unit_Files_LinksServiceImpl implements Unit_Files_LinksService{

	@Autowired
	private Unit_Files_LinksDAO unit_Files_LinksDAO;

	@Transactional
	public void addUnit_Files_Links(Unit_Files_Links unit_Files_Links) {
		unit_Files_LinksDAO.addUnit_Files_Links(unit_Files_Links);
	}

	@Transactional
	public List<Unit_Files_Links> listUnit_Files_Links() {

		return unit_Files_LinksDAO.listUnit_Files_Links();
	}

	@Transactional
	public void removeUnit_Files_Links(Integer id) {
		unit_Files_LinksDAO.removeUnit_Files_Links(id);
	}
}
