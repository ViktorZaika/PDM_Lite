package net.khai.diplom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_UNITS_LINKS")

public class Project_Units_Links {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
    
	@Column(name="project_id")
	private Integer project_id;
	
	@Column(name="unit_id")
	private Integer unit_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public Integer getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(Integer unit_id) {
		this.unit_id = unit_id;
	}
	
	
}
