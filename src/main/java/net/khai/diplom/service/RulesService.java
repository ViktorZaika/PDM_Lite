package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Rules;

public interface RulesService {
	
	public void addRules(Rules rules);

	public List<Rules> listRules();

	public void removeRules(Integer id);
}
