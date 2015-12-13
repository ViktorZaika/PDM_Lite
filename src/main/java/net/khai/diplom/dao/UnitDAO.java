package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Unit;

public interface UnitDAO {

	public void addUnit(Unit unit);

	public List<Unit> listUnit();

	public void removeUnit(Integer id);

}
