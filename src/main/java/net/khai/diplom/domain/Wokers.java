package net.khai.diplom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WOKERS")
public class Wokers {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private Integer role;
	@Column(name = "id_ORG")
	private Integer id_ORG;
	
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getId_ORG() {
		return id_ORG;
	}

	public void setId_ORG(Integer id_ORG) {
		this.id_ORG = id_ORG;
	}

	
}
