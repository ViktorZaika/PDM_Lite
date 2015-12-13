package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Wokers;

public interface WokersService {
	
	public void addWokers(Wokers wokers);

	public List<Wokers> listWokers();

	public void removeWokers(Integer id);
}
