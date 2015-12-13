package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.ProviderDAO;
import net.khai.diplom.domain.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderDAO providerDAO;

	@Transactional
	public void addProvider(Provider provider) {
		providerDAO.addProvider(provider);
	}

	@Transactional
	public List<Provider> listProvider() {

		return providerDAO.listProvider();
	}

	@Transactional
	public void removeProvider(Integer id) {
		providerDAO.removeProvider(id);
	}
}
