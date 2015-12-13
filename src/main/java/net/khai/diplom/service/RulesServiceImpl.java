package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.RulesDAO;
import net.khai.diplom.domain.Rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RulesServiceImpl implements RulesService{

	@Autowired
	private RulesDAO rulesDAO;

	@Transactional
	public void addRules(Rules rules) {
		rulesDAO.addRules(rules);
	}

	@Transactional
	public List<Rules> listRules() {

		return rulesDAO.listRules();
	}

	@Transactional
	public void removeRules(Integer id) {
		rulesDAO.removeRules(id);
	}
}
