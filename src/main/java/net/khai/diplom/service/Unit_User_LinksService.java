package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Unit_User_Links;

public interface Unit_User_LinksService {
	
	public void addUnit_User_Links(Unit_User_Links unit_User_Links);

	public List<Unit_User_Links> listUnit_User_Links();

	public void removeUnit_User_Links(Integer id);
}
