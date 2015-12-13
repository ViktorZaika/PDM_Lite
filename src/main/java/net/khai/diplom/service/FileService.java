package net.khai.diplom.service;

import java.util.List;
import net.khai.diplom.domain.Files;

public interface FileService {
	
	public void addFile(Files file);

	public List<Files> listFile();

	public void removeFile(Integer id);
}
