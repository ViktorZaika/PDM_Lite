package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.ORG_STR_ElementDAO;
import net.khai.diplom.domain.ORG_STR_Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ORG_STR_ElementServiceImpl implements ORG_STR_ElementService{

	@Autowired
	private ORG_STR_ElementDAO oRG_STR_ElementDAO;

	@Transactional
	public void addORG_STR_Element(ORG_STR_Element oRG_STR_Element) {
		oRG_STR_ElementDAO.addORG_STR_Element(oRG_STR_Element);
	}

	@Transactional
	public List<ORG_STR_Element> listORG_STR_Element() {

		return oRG_STR_ElementDAO.listORG_STR_Element();
	}

	@Transactional
	public void removeORG_STR_Element(Integer id) {
		oRG_STR_ElementDAO.removeORG_STR_Element(id);
	}
}
