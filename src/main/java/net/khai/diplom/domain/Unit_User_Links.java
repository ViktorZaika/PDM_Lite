package net.khai.diplom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIT_USER_LINKS")

public class Unit_User_Links {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="unit_id")
	private Integer unit_id;
	
	@Column(name="user_id")
	private Integer user_id;

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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	

}
