package com.mds.springshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Categories implements Serializable {
	private static final long serialVersionUID = -2054386655979281968L;
	
	private int id;
	private String name;
	
	@Id
    @Column(name = "category_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "category_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}