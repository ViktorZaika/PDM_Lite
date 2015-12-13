package net.khai.diplom.service;

import java.util.List;

import net.khai.diplom.dao.FileDAO;
import net.khai.diplom.domain.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDAO fileDAO;

	@Transactional
	public void addFile(Files file) {
		fileDAO.addFile(file);
	}

	@Transactional
	public List<Files> listFile() {

		return fileDAO.listFile();
	}

	@Transactional
	public void removeFile(Integer id) {
		fileDAO.removeFile(id);
	}
}
