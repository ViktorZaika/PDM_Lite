package net.khai.diplom.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIT")
public class Unit {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "material")
	private String material;

	
	@Column(name = "version")
	private String version;

	@Column(name = "weight")
	private int weight;
    
	@Column(name = "scale")
	private int scale;
	
	@Column(name = "list_number")
	private int list_number;
		
	@Column(name = "end_date")
	private Timestamp  end_date;
	
	@Column(name = "id_user_creator")
	private int id_user_creator;
	
	@Column(name = "id_user_norm")
	private int id_user_norm;
	
	@Column(name = "date_control")
	private Timestamp date_control;
	
	@Column(name = "mesure_units")
	private String mesure_units;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "over_unit")
	private int over_unit;
	/**
	 * @return the id
	 */

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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public int getList_number() {
		return list_number;
	}

	public void setList_number(int list_number) {
		this.list_number = list_number;
	}

	
	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public int getId_user_creator() {
		return id_user_creator;
	}

	public void setId_user_creator(int id_user_creator) {
		this.id_user_creator = id_user_creator;
	}

	public int getId_user_norm() {
		return id_user_norm;
	}

	public void setId_user_norm(int id_user_norm) {
		this.id_user_norm = id_user_norm;
	}

	public Timestamp getDate_control() {
		return date_control;
	}

	public void setDate_control(Timestamp date_control) {
		this.date_control = date_control;
	}

	public String getMesure_units() {
		return mesure_units;
	}

	public void setMesure_units(String mesure_units) {
		this.mesure_units = mesure_units;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOver_unit() {
		return over_unit;
	}

	public void setOver_unit(int over_unit) {
		this.over_unit = over_unit;
	}

}
