package net.khai.diplom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_STR_ELEMENT")
public class ORG_STR_Element {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "over_element")
	private int over_element;

	@Column(name = "name")
	private String name;
    
	@Column(name = "id_manager")
	private int id_manager;

	@Column(name = "telephone")
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOver_element() {
		return over_element;
	}

	public void setOver_element(int over_element) {
		this.over_element = over_element;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_manager() {
		return id_manager;
	}

	public void setId_manager(int id_manager) {
		this.id_manager = id_manager;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
