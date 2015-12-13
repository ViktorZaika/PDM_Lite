package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Wokers;

public interface WokersDAO {

	public void addWokers(Wokers wokers);

	public List<Wokers> listWokers();

	public void removeWokers(Integer id);

}
