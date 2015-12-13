package net.khai.diplom.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PROJECTS_LINKS")
public class Projects_Links {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "project_id")
	private Integer project_id;
	
	@Column(name = "prev_id")
	private Integer prev_id;

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

	public Integer getPrev_id() {
		return prev_id;
	}

	public void setPrev_id(Integer prev_id) {
		this.prev_id = prev_id;
	}
}
