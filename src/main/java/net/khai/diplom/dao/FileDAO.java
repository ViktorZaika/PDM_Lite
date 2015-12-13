package net.khai.diplom.dao;

import java.util.List;
import net.khai.diplom.domain.Files;


public interface FileDAO {

	public void addFile(Files file);

	public List<Files> listFile();

	public void removeFile(Integer id);
}
