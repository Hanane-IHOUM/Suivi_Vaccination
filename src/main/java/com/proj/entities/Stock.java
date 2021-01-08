package com.proj.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Stock implements Serializable{

	@Id @GeneratedValue
	private long id;
	
	@OneToMany(targetEntity = Vaccin.class, mappedBy = "stock")
	private List<Vaccin> vaccins;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(List<Vaccin> vaccins) {
		super();
		this.vaccins = vaccins;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Vaccin> getVaccins() {
		return vaccins;
	}

	public void setVaccins(List<Vaccin> vaccins) {
		this.vaccins = vaccins;
	}
	
	

}
