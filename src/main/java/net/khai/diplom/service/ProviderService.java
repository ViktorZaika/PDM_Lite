package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Provider;

public interface ProviderService {
	public void addProvider(Provider provider);

	public List<Provider> listProvider();

	public void removeProvider(Integer id);
}
