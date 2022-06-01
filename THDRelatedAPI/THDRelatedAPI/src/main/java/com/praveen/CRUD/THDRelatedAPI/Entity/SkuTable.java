package com.praveen.CRUD.THDRelatedAPI.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKU_Table")
public class SkuTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKU_ID")
	private int id;
	@Column(name = "SKU_NAME")
	private String name;
	@Column(name = "SKU_DESCRIPTION")
	private String description;
	@Column(name = "SKU_COST")
	private int cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
