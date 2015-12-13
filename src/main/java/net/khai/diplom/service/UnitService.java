package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Unit;

public interface UnitService {
	
	public void addUnit(Unit unit);

	public List<Unit> listUnit();

	public void removeUnit(Integer id);
}
