package net.khai.diplom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIT_FILES_LINKS")

public class Unit_Files_Links {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name="unit_id")
	private Integer unit_id;
	
	@Column(name="file_id")
	private Integer file_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(Integer unit_id) {
		this.unit_id = unit_id;
	}

	public Integer getFile_id() {
		return file_id;
	}

	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}
	
	
}
