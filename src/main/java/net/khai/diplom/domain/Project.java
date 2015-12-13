package net.khai.diplom.domain;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECTS")
public class Project {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "over_proj")
	private Integer over_proj;

	@Column(name = "created")
	private Timestamp created;

	@Column(name = "finished")
	private Timestamp finished;

	@Column(name = "manager")
	private Integer manager;

	@Column(name = "description")
	private String description;
	@Column(name = "links")
	private String links;

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOver_proj() {
		return over_proj;
	}

	public void setOver_proj(Integer over_proj) {
		this.over_proj = over_proj;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getFinished() {
		return finished;
	}

	public void setFinished(Timestamp finished) {
		this.finished = finished;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
