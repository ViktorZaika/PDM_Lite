package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Provider;

public interface ProviderDAO {

	public void addProvider(Provider provider);

	public List<Provider> listProvider();

	public void removeProvider(Integer id);

}
