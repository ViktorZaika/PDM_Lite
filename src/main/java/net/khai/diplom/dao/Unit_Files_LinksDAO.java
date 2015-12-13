package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Unit_Files_Links;

public interface Unit_Files_LinksDAO {

	public void addUnit_Files_Links(Unit_Files_Links unit_Files_Links);

	public List<Unit_Files_Links> listUnit_Files_Links();

	public void removeUnit_Files_Links(Integer id);

}
