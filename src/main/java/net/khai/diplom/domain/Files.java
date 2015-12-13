package net.khai.diplom.domain;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="FILE")

public class Files {
    @Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="extention")
    private String extention;
    
    @Column(name="description")
    private String description;
    
    @Column(name="role")
    private Integer role;
    
    @Column(name="add_date")
    private Timestamp add_date;
    
    @Column(name="version")
    private String version;
    
    @Column(name="size")
    private Integer size;
    
    @Column(name="manager")
    private Integer manager;
    
    
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

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Timestamp getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Timestamp add_date) {
		this.add_date = add_date;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	
    
}
