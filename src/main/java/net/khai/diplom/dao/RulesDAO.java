package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Rules;

public interface RulesDAO {

	public void addRules(Rules rules);

	public List<Rules> listRules();

	public void removeRules(Integer id);

}
