package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.ORG_STR_Element;

public interface ORG_STR_ElementDAO {

	public void addORG_STR_Element(ORG_STR_Element oRG_STR_Element);

	public List<ORG_STR_Element> listORG_STR_Element();

	public void removeORG_STR_Element(Integer id);

}
